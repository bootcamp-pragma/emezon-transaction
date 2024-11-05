package com.emezon.transaction.domain.api;

import com.emezon.transaction.domain.models.Supply;

public interface IRetrieveSupplyInPort {

    Supply findById(String id);

}
