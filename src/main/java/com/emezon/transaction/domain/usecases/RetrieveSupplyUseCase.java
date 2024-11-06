package com.emezon.transaction.domain.usecases;

import com.emezon.transaction.domain.api.IRetrieveSupplyInPort;
import com.emezon.transaction.domain.constants.PaginatedResponseConstraints;
import com.emezon.transaction.domain.models.Supply;
import com.emezon.transaction.domain.spi.ISupplyRepositoryOutPort;
import com.emezon.transaction.domain.utils.PaginatedResponse;
import com.emezon.transaction.domain.utils.PaginatedResponseParams;

import java.util.Optional;

public class RetrieveSupplyUseCase implements IRetrieveSupplyInPort {

    private final ISupplyRepositoryOutPort repository;

    public RetrieveSupplyUseCase(ISupplyRepositoryOutPort repository) {
        this.repository = repository;
    }

    @Override
    public Supply findById(String id) {
        Optional<Supply> supply = repository.findById(id);
        return supply.orElse(null);
    }

    @Override
    public PaginatedResponse<Supply> getAllSupplies(PaginatedResponseParams params) {
        PaginatedResponseConstraints.validateParameters(params);
        return repository.findAll(params);
    }

    @Override
    public PaginatedResponse<Supply> getSuppliesByArticleId(String articleId, PaginatedResponseParams params) {
        PaginatedResponseConstraints.validateParameters(params);
        return repository.findByArticleId(articleId, params);
    }

    @Override
    public PaginatedResponse<Supply> getSuppliesBySuppliedById(String suppliedById, PaginatedResponseParams params) {
        PaginatedResponseConstraints.validateParameters(params);
        return repository.findBySuppliedById(suppliedById, params);
    }
}
