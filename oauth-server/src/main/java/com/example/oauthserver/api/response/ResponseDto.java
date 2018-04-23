package com.example.oauthserver.api.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ResponseDto {

    private String msg;
    private HttpStatus status;
}
