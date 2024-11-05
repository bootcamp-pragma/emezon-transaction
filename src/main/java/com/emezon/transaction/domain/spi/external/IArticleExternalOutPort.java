package com.emezon.transaction.domain.spi.external;

import com.emezon.transaction.domain.models.external.Article;

public interface IArticleExternalOutPort {

    Article findById(String id);

}
