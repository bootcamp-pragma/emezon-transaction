package com.emezon.transaction.infra.security;

import com.emezon.transaction.domain.spi.IJwtHolder;
import com.emezon.transaction.domain.spi.IJwtService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    @Bean
    public IJwtService jwtService() {
        return new JwtService();
    }

    @Bean
    public IJwtHolder jwtHolder() {
        return new JwtHolder();
    }

}
