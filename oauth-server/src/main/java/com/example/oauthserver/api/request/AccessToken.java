package com.example.oauthserver.api.request;

import lombok.Data;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 4. 29
 * Time: 오후 12:00
 */
@Data
public class AccessToken {
    private String access_token;
    private String scope;
    private String token_type;
}
