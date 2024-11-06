package com.emezon.transaction.domain.usecases;

import com.emezon.transaction.domain.api.IPersistSupplyInPort;
import com.emezon.transaction.domain.constants.SupplyConstrains;
import com.emezon.transaction.domain.constants.SupplyErrorMessages;
import com.emezon.transaction.domain.models.Supply;
import com.emezon.transaction.domain.spi.IJwtService;
import com.emezon.transaction.domain.spi.ISupplyRepositoryOutPort;
import com.emezon.transaction.domain.spi.external.IArticleExternalOutPort;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class PersistSupplyUseCase implements IPersistSupplyInPort {

    private final ISupplyRepositoryOutPort repository;
    private final IJwtService jwtService;
    private final IArticleExternalOutPort articleExternal;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    public PersistSupplyUseCase(
            ISupplyRepositoryOutPort repository,
            IJwtService jwtService, IArticleExternalOutPort articleExternal) {
        this.repository = repository;
        this.jwtService = jwtService;
        this.articleExternal = articleExternal;
    }

    @Override
    public Supply createSupply(Supply supply) {
        Supply processedSupply = processAndValidateSupply(supply);
        Supply newSupply = repository.save(processedSupply);
        Map<String, Object> supplyData = new HashMap<>();
        supplyData.put("quantity", newSupply.getQuantity());
        if (supply.getRestockDate() != null) {
            supplyData.put("restockDate", formatter.format(newSupply.getRestockDate()));
        } else {
            supplyData.put("restockDate", null);
        }
        String token = jwtService.generateToken(supplyData);
        try {
            articleExternal.addSupply(newSupply.getArticleId(), token);
        } catch (Exception e) {
            repository.deleteById(newSupply.getId());
            throw e;
        }
        return newSupply;
    }

    @Override
    public void deleteSupply(String id) {
        repository.deleteById(id);
    }

    private Supply processAndValidateSupply(Supply supply) {
        Supply.SupplyBuilder supplyBuilder = Supply.builder();
        if (supply.getArticleId() == null || supply.getArticleId().trim().isEmpty()) {
            throw new IllegalArgumentException(SupplyErrorMessages.SUPPLY_ARTICLE_ID_REQUIRED);
        }
        supplyBuilder.articleId(supply.getArticleId().trim());
        if (supply.getQuantity() < SupplyConstrains.SUPPLY_QUANTITY_MIN_VALUE) {
            throw new IllegalArgumentException(SupplyErrorMessages.SUPPLY_QUANTITY_MIN_VALUE);
        }
        String userId = jwtService.getAuthenticatedUserId();
        if (userId == null || userId.trim().isEmpty()) {
            throw new IllegalArgumentException("User not authenticated");
        }
        supplyBuilder.suppliedById(userId);
        supplyBuilder.quantity(supply.getQuantity());
        if (supply.getCost() != null && supply.getCost() < SupplyConstrains.SUPPLY_COST_MIN_VALUE) {
            throw new IllegalArgumentException(SupplyErrorMessages.SUPPLY_COST_MIN_VALUE);
        }
        supplyBuilder.cost(supply.getCost());
        if (supply.getComments() != null) {
            if (supply.getComments().trim().length() > SupplyConstrains.SUPPLY_COMMENTS_MAX_LENGTH) {
                throw new IllegalArgumentException(SupplyErrorMessages.SUPPLY_COMMENTS_MAX_LENGTH);
            }
            supplyBuilder.comments(supply.getComments().trim());
        }
        if (supply.getRestockDate() != null) {
            supplyBuilder.restockDate(supply.getRestockDate().withNano(0).withSecond(0).withMinute(0));
        }
        return supplyBuilder.build();
    }

}
