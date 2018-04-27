package com.example.oauthserver.api.request;

import lombok.Data;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 4. 27
 * Time: 오후 7:02
 */
@Data
public class FormLoginDto {
    private String username;
    private String password;
}
