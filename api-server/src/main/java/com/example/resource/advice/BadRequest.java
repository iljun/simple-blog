package com.example.resource.advice;

public class BadRequest extends RuntimeException{
    public BadRequest(String msg){
        super(msg);
    }
}
