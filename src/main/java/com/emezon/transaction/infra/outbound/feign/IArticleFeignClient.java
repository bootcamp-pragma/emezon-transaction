package com.emezon.transaction.infra.outbound.feign;

import com.emezon.transaction.domain.models.external.Article;
import com.emezon.transaction.infra.inbound.rest.constants.RestApiConstants;
import com.emezon.transaction.infra.outbound.feign.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "ms-stock-article",
        url = "http://localhost:8073",
        path = RestApiConstants.API_FEIGN_ARTICLE,
        configuration = FeignConfig.class
)
public interface IArticleFeignClient {

    @GetMapping("/{id}")
    Article findArticleById(@PathVariable("id") String id);

}
