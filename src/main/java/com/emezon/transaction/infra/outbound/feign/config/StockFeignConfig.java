package com.emezon.transaction.infra.outbound.feign.config;

import com.emezon.transaction.domain.spi.external.IArticleExternalOutPort;
import com.emezon.transaction.infra.outbound.feign.IArticleFeignClient;
import com.emezon.transaction.infra.outbound.feign.adapters.ArticleFeignExternalAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class StockFeignConfig {

    private final IArticleFeignClient articleFeignClient;

    @Bean
    public IArticleExternalOutPort articleExternalOutPort() {
        return new ArticleFeignExternalAdapter(articleFeignClient);
    }

}
