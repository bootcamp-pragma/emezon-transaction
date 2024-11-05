package com.emezon.transaction.domain.spi;

import com.emezon.transaction.domain.models.Supply;

import java.util.Optional;

public interface ISupplyRepositoryOutPort {

    Supply save(Supply supply);

    Optional<Supply> findById(String id);

    void deleteById(String id);

    // Add pagination

//    Optional<Supply> findByArticleId(String articleId);

//    Optional<Supply> findBySuppliedById(String suppliedById);

}
