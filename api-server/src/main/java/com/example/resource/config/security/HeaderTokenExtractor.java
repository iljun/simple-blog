package com.example.resource.config.security;

import com.example.resource.advice.InvalidJwtException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 1
 * Time: 오전 10:22
 */
@Component
public class HeaderTokenExtractor {

    public static final String HEADER_PREFIX = "Bearer ";

    public String extract(String httpHeader){

        if(StringUtils.isEmpty(httpHeader) || httpHeader.length()<HEADER_PREFIX.length()){
            throw new InvalidJwtException("올바른 토큰 정보가 아닙니다.");
        }

        return httpHeader.substring(HEADER_PREFIX.length(),httpHeader.length());
    }
}
