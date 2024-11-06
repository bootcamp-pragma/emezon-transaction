package com.emezon.transaction.domain.api;

import com.emezon.transaction.domain.models.Supply;
import com.emezon.transaction.domain.utils.PaginatedResponse;
import com.emezon.transaction.domain.utils.PaginatedResponseParams;

public interface IRetrieveSupplyInPort {

    Supply findById(String id);

    PaginatedResponse<Supply> getAllSupplies(PaginatedResponseParams params);

    PaginatedResponse<Supply> getSuppliesByArticleId(String articleId, PaginatedResponseParams params);

    PaginatedResponse<Supply> getSuppliesBySuppliedById(String suppliedById, PaginatedResponseParams params);

}
