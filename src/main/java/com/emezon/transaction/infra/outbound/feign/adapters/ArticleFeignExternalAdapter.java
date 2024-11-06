package com.emezon.transaction.infra.outbound.feign.adapters;

import com.emezon.transaction.domain.models.external.Article;
import com.emezon.transaction.domain.spi.external.IArticleExternalOutPort;
import com.emezon.transaction.infra.outbound.feign.IArticleFeignClient;
import com.emezon.transaction.infra.outbound.feign.dtos.AddSupplyDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ArticleFeignExternalAdapter implements IArticleExternalOutPort {

    private final IArticleFeignClient articleFeignClient;

    @Override
    public Article findById(String id) {
        return articleFeignClient.findArticleById(id);
    }

    @Override
    public Article addSupply(String id, String payload) {
        AddSupplyDTO addSupplyDTO = new AddSupplyDTO(payload);
        return articleFeignClient.addSupply(id, addSupplyDTO);
    }

}
