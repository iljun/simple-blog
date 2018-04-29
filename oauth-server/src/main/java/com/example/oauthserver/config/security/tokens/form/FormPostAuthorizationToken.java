package com.example.oauthserver.config.security.tokens.form;

import com.example.oauthserver.config.security.MemberContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 4. 27
 * Time: 오후 7:04
 */
public class FormPostAuthorizationToken extends UsernamePasswordAuthenticationToken {

    public FormPostAuthorizationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }

    public static FormPostAuthorizationToken getTokenFromAccountContext(MemberContext memberContext) {
        return new FormPostAuthorizationToken(memberContext, memberContext.getPassword(), memberContext.getAuthorities());
    }
}
