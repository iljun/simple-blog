package com.example.oauthserver.advice;

public class BadRequest extends RuntimeException{
    public BadRequest(String msg){
        super(msg);
    }
}
