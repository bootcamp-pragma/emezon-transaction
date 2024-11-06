package com.emezon.transaction.app.errorhandling;

public interface IGlobalExceptionHandler<T> {

    Object handleGeneralException(Exception ex, T request);

}