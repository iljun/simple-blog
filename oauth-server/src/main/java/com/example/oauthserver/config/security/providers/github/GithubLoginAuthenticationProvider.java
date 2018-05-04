package com.example.oauthserver.config.security.providers.github;

import com.example.oauthserver.config.security.GithubContext;
import com.example.oauthserver.config.security.tokens.github.GithubPostAuthorizationToken;
import com.example.oauthserver.config.security.tokens.github.GithubPreAuthorizationToken;
import com.example.oauthserver.config.social.SocialService;
import com.example.oauthserver.domain.member.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 4. 29
 * Time: 오후 2:51
 */
@Component
@Slf4j
public class GithubLoginAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private SocialService socialService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        GithubPreAuthorizationToken token = (GithubPreAuthorizationToken)authentication;

        Member member = socialService.githubSignIn(token.getPrincipal().toString());

        return GithubPostAuthorizationToken.getTokenFromGithubContext(GithubContext.formMemberModel(member));

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return GithubPreAuthorizationToken.class.isAssignableFrom(aClass);
    }
}
