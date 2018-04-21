package com.example.oauthserver.advice;

import javax.naming.AuthenticationException;

public class JwtException extends AuthenticationException {
    public JwtException(String msg){
        super(msg);
    }
}
