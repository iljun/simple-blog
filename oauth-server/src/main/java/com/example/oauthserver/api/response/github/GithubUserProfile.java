package com.example.oauthserver.api.response.github;

import lombok.Data;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 4. 29
 * Time: 오후 12:03
 */
@Data
public class GithubUserProfile {
    private String name;
    private String email;
}
