package com.example.oauthserver.config.security.providers;

import com.example.oauthserver.advice.BadRequest;
import com.example.oauthserver.config.security.MemberContext;
import com.example.oauthserver.config.security.tokens.PostAuthorizationToken;
import com.example.oauthserver.domain.member.Member;
import com.example.oauthserver.domain.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 4. 27
 * Time: 오후 7:20
 */
@Component
public class FormLoginAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        PreAuthenticatedAuthenticationToken token = (PreAuthenticatedAuthenticationToken)authentication;

        Member member = memberRepository.findByEmail(token.getName()).orElseThrow(() -> new BadRequest("존재하지 않는 계정입니다."));

        if(passwordEncoder.matches((String)authentication.getCredentials(),member.getPassword().get()))
            return PostAuthorizationToken.getTokenFromAccountContext(MemberContext.formMemberModel(member));

        throw new BadRequest("인증 정보가 정확하지 않습니다.");

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return PreAuthenticatedAuthenticationToken.class.isAssignableFrom(aClass);
    }
}
