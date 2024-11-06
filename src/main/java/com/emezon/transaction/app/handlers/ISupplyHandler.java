package com.emezon.transaction.app.handlers;

import com.emezon.transaction.app.dtos.CreateSupplyDTO;
import com.emezon.transaction.app.dtos.SupplyDTO;

public interface ISupplyHandler {

    SupplyDTO createSupply(CreateSupplyDTO supply);

    SupplyDTO getSupplyById(String supplyId);

}
