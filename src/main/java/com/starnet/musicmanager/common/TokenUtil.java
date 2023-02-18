package com.starnet.musicmanager.common;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class TokenUtil {
    public static String getToken(String id,String key){
        return JWT.create().withAudience(id).sign(Algorithm.HMAC256(key));
    }
}
