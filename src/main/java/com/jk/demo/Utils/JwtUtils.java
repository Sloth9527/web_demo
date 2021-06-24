package com.jk.demo.Utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.jk.demo.dao.entity.User;
import java.util.Date;

public class JwtUtils {
  // 过期时间
  private static final long EXPIRE_TIME = 24 * 60 * 60 * 1000;

  public static String sign(User u) {
    if (u == null) {
      return null;
    }
    Date expireDate = new Date(System.currentTimeMillis() + EXPIRE_TIME);
    Algorithm algorithm = Algorithm.HMAC256(u.getPassword());
    return JWT.create()
        .withClaim("username", u.getUsername())
        .withExpiresAt(expireDate)
        .sign(algorithm);
  }

  public static Boolean verify(String token, User u) {
    if (token == null || u == null) {
      return false;
    }

    try {
      Algorithm algorithm = Algorithm.HMAC256(u.getPassword());

      JWTVerifier verifier = JWT.require(algorithm).withClaim("username", u.getUsername()).build();

      DecodedJWT jwt = verifier.verify(token);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public static Boolean isTokenExpired(String token) {
    if (token == null) {
      return null;
    }
    try {
      DecodedJWT jwt = JWT.decode(token);
      Date expiresAt = jwt.getExpiresAt();
      return new Date().after(expiresAt);
    } catch (JWTDecodeException e) {
      return true;
    }
  }

  public static String getUsername(String token) {
    if (token == null) {
      return null;
    }
    try {
      DecodedJWT jwt = JWT.decode(token);
      return jwt.getClaim("username").asString();
    } catch (JWTDecodeException e) {
      return null;
    }
  }
}
