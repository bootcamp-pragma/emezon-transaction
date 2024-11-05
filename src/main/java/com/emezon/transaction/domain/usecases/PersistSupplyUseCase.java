package com.emezon.transaction.domain.usecases;

import com.emezon.transaction.domain.api.IPersistSupplyInPort;
import com.emezon.transaction.domain.constants.SupplyConstrains;
import com.emezon.transaction.domain.constants.SupplyErrorMessages;
import com.emezon.transaction.domain.models.Supply;
import com.emezon.transaction.domain.models.external.Article;
import com.emezon.transaction.domain.spi.IJwtService;
import com.emezon.transaction.domain.spi.ISupplyRepositoryOutPort;
import com.emezon.transaction.domain.spi.external.IArticleExternalOutPort;

public class PersistSupplyUseCase implements IPersistSupplyInPort {

    private final ISupplyRepositoryOutPort repository;
    private final IJwtService jwtService;
    private final IArticleExternalOutPort articleExternal;

    public PersistSupplyUseCase(
            ISupplyRepositoryOutPort repository,
            IJwtService jwtService, IArticleExternalOutPort articleExternal) {
        this.repository = repository;
        this.jwtService = jwtService;
        this.articleExternal = articleExternal;
    }

    @Override
    public Supply createSupply(Supply supply) {
        Article article = articleExternal.findById(supply.getArticleId());
        if (article == null) {
            throw new IllegalArgumentException("Article not found");
        }
        System.out.println("Article found: " + article.getName());
        Supply processedSupply = processAndValidateSupply(supply);
        Supply newSupply = repository.save(processedSupply);
        // llamar al microservicio de inventario para actualizar el stock
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
        if (supply.getSuppliedById() == null || supply.getSuppliedById().trim().isEmpty()) {
            throw new IllegalArgumentException(SupplyErrorMessages.SUPPLY_SUPPLIED_BY_ID_REQUIRED);
        }
        supplyBuilder.suppliedById(supply.getSuppliedById().trim());
        if (supply.getQuantity() < SupplyConstrains.SUPPLY_QUANTITY_MIN_VALUE) {
            throw new IllegalArgumentException(SupplyErrorMessages.SUPPLY_QUANTITY_MIN_VALUE);
        }
        supplyBuilder.quantity(supply.getQuantity());
        if (supply.getCost() != null && supply.getCost() < SupplyConstrains.SUPPLY_COST_MIN_VALUE) {
            throw new IllegalArgumentException(SupplyErrorMessages.SUPPLY_COST_MIN_VALUE);
        }
        supplyBuilder.cost(supply.getCost());
        if (supply.getComments() != null) {
            if (supply.getComments().trim().length() > SupplyConstrains.SUPPLY_COMMENT_MAX_LENGTH) {
                throw new IllegalArgumentException(SupplyErrorMessages.SUPPLY_COMMENTS_MAX_LENGTH);
            }
            supplyBuilder.comments(supply.getComments().trim());
        }
        supplyBuilder.restockDate(supply.getRestockDate());
        return supplyBuilder.build();
    }

}
