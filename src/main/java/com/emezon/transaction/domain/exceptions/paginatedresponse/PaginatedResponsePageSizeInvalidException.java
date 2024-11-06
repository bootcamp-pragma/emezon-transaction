package com.emezon.transaction.domain.exceptions.paginatedresponse;

import com.emezon.transaction.domain.constants.PaginatedResponseErrorMessages;

public class PaginatedResponsePageSizeInvalidException extends RuntimeException {
    public PaginatedResponsePageSizeInvalidException() {
        super(PaginatedResponseErrorMessages.PAGE_SIZE_INVALID);
    }
}
