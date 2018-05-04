package com.example.resource.advice;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 1
 * Time: 오전 10:25
 */
public class InvalidJwtException extends RuntimeException{
    public InvalidJwtException(String msg){
        super(msg);
    }
}
