package com.example.oauthserver.advice;

public class LoginException extends RuntimeException {
    public LoginException(String msg){
        super(msg);
    }
}
