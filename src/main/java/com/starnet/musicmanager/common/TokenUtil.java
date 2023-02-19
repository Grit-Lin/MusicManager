package com.starnet.musicmanager.common;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class TokenUtil {
    private static final Algorithm algorithm = Algorithm.HMAC256("test");

    public static String getToken(String id) {
        return JWT.create()
                .withIssuer("TokenUtil-getToken")
                .withIssuedAt(new Date())
                .withSubject("user")
                .withAudience(id)
                .sign(algorithm);
    }

//    public static String verify(String jwt) {
//        JWTVerifier verifier = JWT.require(algorithm)
//                .build();
//        DecodedJWT decodedJWT = verifier.verify(jwt);
//    }
}
