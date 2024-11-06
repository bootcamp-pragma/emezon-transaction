package com.emezon.transaction.infra.outbound.feign.config;

import com.emezon.transaction.domain.spi.IJwtHolder;
import com.emezon.transaction.infra.outbound.feign.utils.CustomErrorDecoder;
import com.emezon.transaction.infra.outbound.feign.utils.FeignClientInterceptor;
import feign.codec.ErrorDecoder;
import feign.okhttp.OkHttpClient;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.support.FeignHttpClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class FeignConfig {

    private final IJwtHolder jwtHolder;

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient();
    }

    @Bean
    public ErrorDecoder errorDecoder(){
        return new CustomErrorDecoder();
    }

    @Bean
    public FeignClientInterceptor feignClientInterceptor() {
        return new FeignClientInterceptor(jwtHolder);
    }

}
