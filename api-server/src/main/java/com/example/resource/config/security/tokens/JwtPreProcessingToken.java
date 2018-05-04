package com.example.resource.config.security.tokens;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 1
 * Time: 오전 10:48
 */
public class JwtPreProcessingToken extends UsernamePasswordAuthenticationToken {

    private JwtPreProcessingToken(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public JwtPreProcessingToken(String token){
        this(token,null);//null이 예외를 발생시키는 경우를 생각하자
    }
}
