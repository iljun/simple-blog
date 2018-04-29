package com.example.oauthserver.config.security.tokens.github;

import com.example.oauthserver.config.security.GithubContext;
import com.example.oauthserver.config.security.MemberContext;
import com.example.oauthserver.config.security.tokens.form.FormPostAuthorizationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 4. 29
 * Time: 오후 2:52
 */
public class GithubPostAuthorizationToken extends UsernamePasswordAuthenticationToken{

    public GithubPostAuthorizationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }

    public static GithubPostAuthorizationToken getTokenFromGithubContext(GithubContext githubContext) {
        return new GithubPostAuthorizationToken(githubContext, githubContext.getMember().getEmail(), githubContext.getAuthorities());
    }
}
