package com.example.oauthserver.config.security.providers;

import com.example.oauthserver.advice.BadRequest;
import com.example.oauthserver.advice.LoginException;
import com.example.oauthserver.config.security.MemberContext;
import com.example.oauthserver.config.security.tokens.PostAuthorizationToken;
import com.example.oauthserver.config.security.tokens.PreAuthorizationToken;
import com.example.oauthserver.domain.member.Member;
import com.example.oauthserver.domain.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;

import java.util.Optional;

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

        PreAuthorizationToken token = (PreAuthorizationToken)authentication;

        Optional<String> username = Optional.ofNullable((String)token.getPrincipal());
        Optional<String> password = Optional.ofNullable((String)token.getCredentials());

        username.orElseThrow(() -> new LoginException("계정을 입력하세요."));
        password.orElseThrow(() -> new LoginException("패스워드를 입력하세요."));

        Member member = memberRepository.findByEmail(username.get()).orElseThrow(() -> new LoginException("존재하지 않는 계정입니다."));

        if(isCorrectPassword(password.get(),member))
            return PostAuthorizationToken.getTokenFromAccountContext(MemberContext.formMemberModel(member));

        throw new LoginException("패스워드가 일치하지 않습니다.");

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return PreAuthorizationToken.class.isAssignableFrom(aClass);
    }

    private boolean isCorrectPassword(String password, Member member) {
        return passwordEncoder.matches(password, member.getPassword());
    }
}
