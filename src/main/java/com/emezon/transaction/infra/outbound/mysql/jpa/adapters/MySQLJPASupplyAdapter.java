package com.emezon.transaction.infra.outbound.mysql.jpa.adapters;

import com.emezon.transaction.domain.models.Supply;
import com.emezon.transaction.domain.spi.ISupplyRepositoryOutPort;
import com.emezon.transaction.infra.outbound.mysql.jpa.entities.SupplyEntity;
import com.emezon.transaction.infra.outbound.mysql.jpa.mappers.SupplyEntityMapper;
import com.emezon.transaction.infra.outbound.mysql.jpa.repositories.IMySQLJpaSupplyRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class MySQLJPASupplyAdapter implements ISupplyRepositoryOutPort {

    private final IMySQLJpaSupplyRepository repository;

    @Override
    public Supply save(Supply supply) {
        SupplyEntity supplyEntity = SupplyEntityMapper.toEntity(supply);
        SupplyEntity savedSupplyEntity = repository.save(supplyEntity);
        return SupplyEntityMapper.toDomain(savedSupplyEntity);
    }

    @Override
    public Optional<Supply> findById(String id) {
        Optional<SupplyEntity> supplyEntity = repository.findById(id);
        return supplyEntity.map(SupplyEntityMapper::toDomain);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

}
