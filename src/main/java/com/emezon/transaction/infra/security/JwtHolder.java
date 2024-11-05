package com.emezon.transaction.infra.security;

import com.emezon.transaction.domain.spi.IJwtHolder;

public class JwtHolder implements IJwtHolder {

    public static final ThreadLocal<String> tokenHolder = new ThreadLocal<>();

    @Override
    public String getToken() {
        return tokenHolder.get();
    }

    @Override
    public void setToken(String token) {
        tokenHolder.set(token);
    }

    @Override
    public void clearToken() {
        tokenHolder.remove();
    }

}
