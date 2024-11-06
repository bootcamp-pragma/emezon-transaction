package com.emezon.transaction.domain.spi;

import com.emezon.transaction.domain.models.Supply;
import com.emezon.transaction.domain.utils.PaginatedResponse;
import com.emezon.transaction.domain.utils.PaginatedResponseParams;

import java.util.Optional;

public interface ISupplyRepositoryOutPort {

    Supply save(Supply supply);

    Optional<Supply> findById(String id);

    void deleteById(String id);

    PaginatedResponse<Supply> findAll(PaginatedResponseParams params);

    PaginatedResponse<Supply> findByArticleId(String articleId, PaginatedResponseParams params);

    PaginatedResponse<Supply> findBySuppliedById(String suppliedById, PaginatedResponseParams params);

}
