package com.example.resource.advice;

import com.example.resource.api.response.ResponseDto;
import com.example.resource.api.response.ResponseStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDto> defaultExceptionHandler(Exception e){
        log.error(e.getMessage());
        return new ResponseEntity<ResponseDto>(
                ResponseDto.builder()
                            .msg("Server Error")
                            .status(ResponseStatus.FAIL)
                            .build()
                , HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(BadRequest.class)
    public ResponseEntity<ResponseDto> badRequestExceptionHandler(BadRequest e){
        log.error(e.getMessage());
        return new ResponseEntity<ResponseDto>(
                ResponseDto.builder()
                            .msg(e.getMessage())
                            .status(ResponseStatus.BADREQUEST)
                            .build(),
                HttpStatus.BAD_REQUEST
        );
    }

    //TODO 토큰 유효성 검사 추가
}
