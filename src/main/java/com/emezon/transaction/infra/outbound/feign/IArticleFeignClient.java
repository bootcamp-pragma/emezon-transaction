package com.emezon.transaction.infra.outbound.feign;

import com.emezon.transaction.domain.models.external.Article;
import com.emezon.transaction.infra.inbound.rest.constants.RestApiConstants;
import com.emezon.transaction.infra.outbound.feign.config.FeignConfig;
import com.emezon.transaction.infra.outbound.feign.dtos.AddSupplyDTO;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "ms-stock-article",
        url = "http://localhost:8073",
        path = RestApiConstants.API_FEIGN_ARTICLE,
        configuration = FeignConfig.class
)
public interface IArticleFeignClient {

    @GetMapping("/{id}")
    Article findArticleById(@PathVariable("id") String id);

    @PatchMapping("/{id}/add-supply")
    Article addSupply(@PathVariable("id") String id, @RequestBody @Valid AddSupplyDTO addSupplyDTO);

}
