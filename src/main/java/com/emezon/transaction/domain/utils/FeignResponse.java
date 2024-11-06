package com.emezon.transaction.domain.utils;

public class FeignResponse<T> {

    private int status;
    private T body;

    public FeignResponse(int status, T body) {
        this.status = status;
        this.body = body;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
