package com.example.oauthserver.domain.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDto {
    private String msg;
}
