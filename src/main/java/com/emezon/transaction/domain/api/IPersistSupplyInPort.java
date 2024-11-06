package com.emezon.transaction.domain.api;

import com.emezon.transaction.domain.models.Supply;

public interface IPersistSupplyInPort {

    Supply createSupply(Supply supply);

    void deleteSupply(String id);

}
