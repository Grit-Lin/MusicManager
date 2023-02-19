package com.starnet.musicmanager.common.exception;

public class LoginFailedException extends MyException {
    public LoginFailedException(String message) {
        super("loginFailedException:" + message);
    }
}
