package com.starnet.musicmanager.common;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class AuthUtil {
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    static public String Encrypt(String password) {
        return encoder.encode(password);
    }

    static public Boolean Verify(String password, String hashedPassword) {
        return encoder.matches(password, hashedPassword);
    }
}
