package com.starnet.musicmanager.common.exception;

public class TokenNotFoundException extends MyException {
    public TokenNotFoundException(String message) {
        super("tokenNotFoundException:" + message);
    }
}
