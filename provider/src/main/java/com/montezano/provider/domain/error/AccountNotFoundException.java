package com.montezano.provider.domain.error;

public class AccountNotFoundException  extends RuntimeException {
    public AccountNotFoundException(String message) {
        super(message);
    }
}
