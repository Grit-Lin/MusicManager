package com.starnet.musicmanager.common.exception;

public class PasswordVerificationException extends MyException {
    public PasswordVerificationException(String message) {
        super("passwordVerificationException: " + message);
    }
}
