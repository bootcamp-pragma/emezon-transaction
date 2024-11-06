package com.emezon.transaction.infra.outbound.mysql.jpa.adapters;

import com.emezon.transaction.domain.models.Supply;
import com.emezon.transaction.domain.spi.ISupplyRepositoryOutPort;
import com.emezon.transaction.domain.utils.PaginatedResponse;
import com.emezon.transaction.domain.utils.PaginatedResponseParams;
import com.emezon.transaction.infra.outbound.mysql.jpa.entities.SupplyEntity;
import com.emezon.transaction.infra.outbound.mysql.jpa.mappers.SupplyEntityMapper;
import com.emezon.transaction.infra.outbound.mysql.jpa.repositories.IMySQLJpaSupplyRepository;
import com.emezon.transaction.infra.outbound.mysql.jpa.utils.PageableUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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

    @Override
    public PaginatedResponse<Supply> findAll(PaginatedResponseParams params) {
        Pageable pageable = PageableUtils.getFromPaginatedResponseParams(params);
        Page<SupplyEntity> pageRes = repository.findAll(pageable);
        PaginatedResponse<Supply> paginatedResponse = new PaginatedResponse<>();
        paginatedResponse.setItems(pageRes.getContent().stream().map(SupplyEntityMapper::toDomain).toList());
        paginatedResponse.setTotalItems(pageRes.getTotalElements());
        paginatedResponse.setTotalPages(pageRes.getTotalPages());
        paginatedResponse.setPage(pageRes.getNumber());
        paginatedResponse.setSize(pageRes.getSize());
        return paginatedResponse;
    }

    @Override
    public PaginatedResponse<Supply> findByArticleId(String articleId, PaginatedResponseParams params) {
        Pageable pageable = PageableUtils.getFromPaginatedResponseParams(params);
        Page<SupplyEntity> pageRes = repository.findAllByArticleId(articleId, pageable);
        PaginatedResponse<Supply> paginatedResponse = new PaginatedResponse<>();
        paginatedResponse.setItems(pageRes.getContent().stream().map(SupplyEntityMapper::toDomain).toList());
        paginatedResponse.setTotalItems(pageRes.getTotalElements());
        paginatedResponse.setTotalPages(pageRes.getTotalPages());
        paginatedResponse.setPage(pageRes.getNumber());
        paginatedResponse.setSize(pageRes.getSize());
        return paginatedResponse;
    }

    @Override
    public PaginatedResponse<Supply> findBySuppliedById(String suppliedById, PaginatedResponseParams params) {
        Pageable pageable = PageableUtils.getFromPaginatedResponseParams(params);
        Page<SupplyEntity> pageRes = repository.findAllBySuppliedById(suppliedById, pageable);
        PaginatedResponse<Supply> paginatedResponse = new PaginatedResponse<>();
        paginatedResponse.setItems(pageRes.getContent().stream().map(SupplyEntityMapper::toDomain).toList());
        paginatedResponse.setTotalItems(pageRes.getTotalElements());
        paginatedResponse.setTotalPages(pageRes.getTotalPages());
        paginatedResponse.setPage(pageRes.getNumber());
        paginatedResponse.setSize(pageRes.getSize());
        return paginatedResponse;
    }

}
