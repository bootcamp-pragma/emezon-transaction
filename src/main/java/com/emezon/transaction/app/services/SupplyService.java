package com.emezon.transaction.app.services;

import com.emezon.transaction.app.dtos.CreateSupplyDTO;
import com.emezon.transaction.app.dtos.SupplyDTO;
import com.emezon.transaction.app.handlers.ISupplyHandler;
import com.emezon.transaction.app.mappers.SupplyMapper;
import com.emezon.transaction.domain.api.IPersistSupplyInPort;
import com.emezon.transaction.domain.api.IRetrieveSupplyInPort;
import com.emezon.transaction.domain.models.Supply;
import lombok.RequiredArgsConstructor;

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
}
