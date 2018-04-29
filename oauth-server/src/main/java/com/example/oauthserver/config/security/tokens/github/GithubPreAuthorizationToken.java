package com.example.oauthserver.config.security.tokens.github;

import com.example.oauthserver.api.request.github.GithubCode;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 4. 29
 * Time: 오후 2:52
 */
public class GithubPreAuthorizationToken extends UsernamePasswordAuthenticationToken {

    public GithubPreAuthorizationToken(String code,String email) {
        super(code, email);
    }

    public GithubPreAuthorizationToken(GithubCode code){
        this(code.getCode(),null);
    }
}
