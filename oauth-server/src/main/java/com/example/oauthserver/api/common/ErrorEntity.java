package com.example.oauthserver.api.common;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ErrorEntity {
    private HttpStatus httpStatus;
    private String msg;
}
