package com.example.oauthserver.advice;

import com.example.oauthserver.api.response.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class MyExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDto> defaultExceptionHandler(Exception e){
        log.error(e.getMessage());

        return new ResponseEntity(ResponseDto
                                    .builder()
                                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                                    .msg(e.getMessage())
                                    .build(),
                                    HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(JwtException.class)
    public ResponseEntity<ResponseDto> jwtExceptionHandler(JwtException e){
        log.error(e.getMessage());

        return new ResponseEntity(ResponseDto
                                    .builder()
                                    .status(HttpStatus.UNAUTHORIZED)
                                    .msg(e.getMessage())
                                    .build(),
                                    HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(LoginException.class)
    public ResponseEntity<ResponseDto> loginExceptionHandler(LoginException e){
        log.error(e.getMessage());

        return new ResponseEntity(ResponseDto
                                    .builder()
                                    .status(HttpStatus.UNAUTHORIZED)
                                    .msg(e.getMessage())
                                    .build(),
                                    HttpStatus.UNAUTHORIZED);
    }
}
