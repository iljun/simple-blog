//package com.example.oauthserver.advice;
//
//import com.example.blog.api.common.ErrorEntity;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//@ControllerAdvice
//@Slf4j
//public class MyExceptionHandler {
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorEntity> defaultExceptionHandler(Exception e){
//        log.error(e.getMessage());
//
//        return new ResponseEntity(ErrorEntity
//                                    .builder()
//                                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//                                    .msg(e.getMessage())
//                                    .build(),
//                                    HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    @ExceptionHandler(JwtException.class)
//    public ResponseEntity<ErrorEntity> jwtExceptionHandler(JwtException e){
//        log.error(e.getMessage());
//
//        return new ResponseEntity(ErrorEntity
//                                    .builder()
//                                    .httpStatus(HttpStatus.UNAUTHORIZED)
//                                    .msg(e.getMessage())
//                                    .build(),
//                                    HttpStatus.UNAUTHORIZED);
//    }
//
//    @ExceptionHandler(FailLogin.class)
//    public ResponseEntity<ErrorEntity> loginExceptionHandler(FailLogin e){
//        log.error(e.getMessage());
//
//        return new ResponseEntity(ErrorEntity
//                                    .builder()
//                                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//                                    .msg(e.getMessage())
//                                    .build(),
//                                    HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//}
