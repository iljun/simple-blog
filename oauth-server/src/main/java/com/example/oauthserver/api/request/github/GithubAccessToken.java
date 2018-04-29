package com.example.oauthserver.api.request.github;

import lombok.Data;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 4. 29
 * Time: 오후 5:13
 */
@Data
public class GithubAccessToken {
    private String access_token;
    private String scope;
    private String token_type;
}
