package com.example.oauthserver.advice;

public class FailLogin extends RuntimeException {
    public FailLogin(String msg){
        super(msg);
    }
}
