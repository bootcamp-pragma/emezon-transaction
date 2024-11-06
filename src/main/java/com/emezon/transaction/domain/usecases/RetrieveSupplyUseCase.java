package com.emezon.transaction.domain.usecases;

import com.emezon.transaction.domain.api.IRetrieveSupplyInPort;
import com.emezon.transaction.domain.models.Supply;
import com.emezon.transaction.domain.spi.ISupplyRepositoryOutPort;

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
}
