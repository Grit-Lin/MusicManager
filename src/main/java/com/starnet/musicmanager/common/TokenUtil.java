package com.starnet.musicmanager.common;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Date;

public class TokenUtil {
    private static final String SECRET = "test";
    private static final Algorithm ALGORITHM = Algorithm.HMAC256(SECRET);
    private static final Integer EXPIRATION = 14400;
    public static final String AUTH_HEADER_KEY = "Authorization";

    public static String getToken(Long userId) {
        Calendar expire = Calendar.getInstance();
        expire.add(Calendar.SECOND, EXPIRATION);

        return JWT.create()
                .withIssuer("TokenUtil-getToken")
                .withIssuedAt(new Date())
                .withExpiresAt(expire.getTime())
                .withSubject("user")
                .withAudience("android")
//                .withJWTId(user.getId())
                .withClaim("uid", userId)
                .sign(ALGORITHM);
    }

    public static TokenContext verify(String jwt) throws JWTVerificationException {
//        throw new JWTVerificationException("test");
        JWTVerifier verifier = JWT.require(ALGORITHM).build();
        DecodedJWT decodedJWT = verifier.verify(jwt);
        TokenContext tokenContext = new TokenContext();
        tokenContext.setUserId(decodedJWT.getClaim("uid").asLong());
        return tokenContext;
    }
}
