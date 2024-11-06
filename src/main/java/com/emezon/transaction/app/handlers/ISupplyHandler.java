package com.emezon.transaction.app.handlers;

import com.emezon.transaction.app.dtos.CreateSupplyDTO;
import com.emezon.transaction.app.dtos.SupplyDTO;
import com.emezon.transaction.domain.utils.PaginatedResponse;
import org.springframework.util.MultiValueMap;

public interface ISupplyHandler {

    SupplyDTO createSupply(CreateSupplyDTO supply);

    SupplyDTO getSupplyById(String supplyId);

    PaginatedResponse<SupplyDTO> getAllSupplies(MultiValueMap<String, String> queryParams);

    PaginatedResponse<SupplyDTO> getSuppliesByArticleId(String articleId, MultiValueMap<String, String> queryParams);

    PaginatedResponse<SupplyDTO> getSuppliesBySuppliedById(String suppliedById, MultiValueMap<String, String> queryParams);

}
