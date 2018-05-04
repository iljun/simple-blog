package com.example.oauthserver.api.request.google;

import lombok.Data;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 4. 30
 * Time: 오후 5:02
 */
@Data
public class GoogleProfile {
    private String token;
    private Long id;
    private String name;
    private String imgUrl;
    private String email;
}
