package com.starnet.musicmanager.common;

public class AuthUtil {
    static public String Encrypt(String password) {
        return password;
    }

    static public Boolean Verify(String password, String hashedPassword) {
        return password.equals(hashedPassword);
    }
}
