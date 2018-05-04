package com.example.oauthserver.api.response;

import lombok.Data;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 4
 * Time: 오후 4:18
 */
@Data
public class JWTtoken {
    private String jwtToken;
    private String refreshToken;

    public JWTtoken(String jwtToken, String refreshToken){
        this.jwtToken = jwtToken;
        this.refreshToken = refreshToken;
    }
}
