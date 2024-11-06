package com.emezon.transaction.infra.config;

import com.emezon.transaction.app.handlers.ISupplyHandler;
import com.emezon.transaction.app.services.SupplyService;
import com.emezon.transaction.domain.api.IPersistSupplyInPort;
import com.emezon.transaction.domain.api.IRetrieveSupplyInPort;
import com.emezon.transaction.domain.spi.IJwtService;
import com.emezon.transaction.domain.spi.ISupplyRepositoryOutPort;
import com.emezon.transaction.domain.spi.external.IArticleExternalOutPort;
import com.emezon.transaction.domain.usecases.PersistSupplyUseCase;
import com.emezon.transaction.domain.usecases.RetrieveSupplyUseCase;
import com.emezon.transaction.infra.outbound.mysql.jpa.adapters.MySQLJPASupplyAdapter;
import com.emezon.transaction.infra.outbound.mysql.jpa.repositories.IMySQLJpaSupplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SupplyConfig {

    private final IMySQLJpaSupplyRepository repository;
    private final IJwtService jwtService;
    private final IArticleExternalOutPort articleExternal;


    @Bean
    public ISupplyRepositoryOutPort supplyRepositoryOutPort() {
        return new MySQLJPASupplyAdapter(repository);
    }

    @Bean
    public IPersistSupplyInPort persistSupplyInPort() {
        return new PersistSupplyUseCase(supplyRepositoryOutPort(), jwtService, articleExternal);
    }

    @Bean
    public IRetrieveSupplyInPort retrieveSupplyInPort() {
        return new RetrieveSupplyUseCase(supplyRepositoryOutPort());
    }

    @Bean
    public ISupplyHandler supplyHandler() {
        return new SupplyService(persistSupplyInPort(), retrieveSupplyInPort());
    }

}
