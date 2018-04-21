package com.example.resource.api.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDto {
    private String msg;
    private ResponseStatus status;

}
