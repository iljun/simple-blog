package com.example.oauthserver.advice;

import javax.naming.AuthenticationException;

public class JwtException extends RuntimeException {
    public JwtException(String msg){
        super(msg);
    }
}
