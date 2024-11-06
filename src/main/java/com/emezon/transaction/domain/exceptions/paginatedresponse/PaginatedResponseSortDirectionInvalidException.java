package com.emezon.transaction.domain.exceptions.paginatedresponse;

import com.emezon.transaction.domain.constants.PaginatedResponseErrorMessages;

public class PaginatedResponseSortDirectionInvalidException extends RuntimeException {

    public PaginatedResponseSortDirectionInvalidException() {
        super(PaginatedResponseErrorMessages.SORT_DIRECTION_INVALID);
    }

}
