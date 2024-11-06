package com.emezon.transaction.domain.exceptions.paginatedresponse;

import com.emezon.transaction.domain.constants.PaginatedResponseErrorMessages;

public class PaginatedResponsePageNumberInvalidException extends RuntimeException {
    public PaginatedResponsePageNumberInvalidException() {
        super(PaginatedResponseErrorMessages.PAGE_NUMBER_INVALID);
    }
}
