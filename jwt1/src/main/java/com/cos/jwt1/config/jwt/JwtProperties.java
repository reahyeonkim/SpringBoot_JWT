package com.cos.jwt1.config.jwt;

public interface JwtProperties {
    String SECRET = "김래현"; //서버만 알고 있는 비밀값
    int EXPIRATION_TIME = 864000000; //10일
    String TOKEN_PREFIX = "Bearer";
    String HEADER_STRING = "Authorization";
}
