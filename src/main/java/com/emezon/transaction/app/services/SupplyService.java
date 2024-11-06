package com.emezon.transaction.app.services;

import com.emezon.transaction.app.dtos.CreateSupplyDTO;
import com.emezon.transaction.app.dtos.SupplyDTO;
import com.emezon.transaction.app.handlers.ISupplyHandler;
import com.emezon.transaction.app.mappers.SupplyMapper;
import com.emezon.transaction.domain.api.IPersistSupplyInPort;
import com.emezon.transaction.domain.api.IRetrieveSupplyInPort;
import com.emezon.transaction.domain.models.Supply;
import com.emezon.transaction.domain.utils.PaginatedResponse;
import com.emezon.transaction.domain.utils.PaginatedResponseParams;
import com.emezon.transaction.domain.utils.PaginatedResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.util.MultiValueMap;

import java.util.List;

@RequiredArgsConstructor
public class SupplyService implements ISupplyHandler {

    private final IPersistSupplyInPort persistSupply;
    private final IRetrieveSupplyInPort retrieveSupply;

    @Override
    public SupplyDTO createSupply(CreateSupplyDTO supply) {
        Supply supplyModel = SupplyMapper.toModel(supply);
        Supply createdSupply = persistSupply.createSupply(supplyModel);
        return SupplyMapper.toDTO(createdSupply);
    }

    @Override
    public SupplyDTO getSupplyById(String supplyId) {
        Supply supply = retrieveSupply.findById(supplyId);
        return SupplyMapper.toDTO(supply);
    }

    @Override
    public PaginatedResponse<SupplyDTO> getAllSupplies(MultiValueMap<String, String> queryParams) {
        PaginatedResponseParams params = PaginatedResponseUtils.getFromMap(queryParams);
        PaginatedResponse<Supply> supplies = retrieveSupply.getAllSupplies(params);
        List<SupplyDTO> supplyDTOS = supplies.getItems().stream().map(SupplyMapper::toDTO).toList();
        return new PaginatedResponse<>(
                supplyDTOS,
                supplies.getPage(),
                supplies.getSize(),
                supplies.getTotalItems(),
                supplies.getTotalPages());
    }

    @Override
    public PaginatedResponse<SupplyDTO> getSuppliesByArticleId(String articleId, MultiValueMap<String, String> queryParams) {
        PaginatedResponseParams params = PaginatedResponseUtils.getFromMap(queryParams);
        PaginatedResponse<Supply> supplies = retrieveSupply.getSuppliesByArticleId(articleId, params);
        List<SupplyDTO> supplyDTOS = supplies.getItems().stream().map(SupplyMapper::toDTO).toList();
        return new PaginatedResponse<>(
                supplyDTOS,
                supplies.getPage(),
                supplies.getSize(),
                supplies.getTotalItems(),
                supplies.getTotalPages());
    }

    @Override
    public PaginatedResponse<SupplyDTO> getSuppliesBySuppliedById(String suppliedById, MultiValueMap<String, String> queryParams) {
        PaginatedResponseParams params = PaginatedResponseUtils.getFromMap(queryParams);
        PaginatedResponse<Supply> supplies = retrieveSupply.getSuppliesBySuppliedById(suppliedById, params);
        List<SupplyDTO> supplyDTOS = supplies.getItems().stream().map(SupplyMapper::toDTO).toList();
        return new PaginatedResponse<>(
                supplyDTOS,
                supplies.getPage(),
                supplies.getSize(),
                supplies.getTotalItems(),
                supplies.getTotalPages());
    }
}
