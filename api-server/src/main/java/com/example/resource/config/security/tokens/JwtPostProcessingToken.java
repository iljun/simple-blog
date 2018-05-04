package com.example.resource.config.security.tokens;

import com.example.resource.config.security.UserRole;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 1
 * Time: 오전 10:56
 */
public class JwtPostProcessingToken extends UsernamePasswordAuthenticationToken {

    private JwtPostProcessingToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }

    public JwtPostProcessingToken(String username, UserRole role) {
        super(username, null, parseAuthorities(role));
    }

    private static Collection<? extends GrantedAuthority> parseAuthorities(UserRole userRole) {
        return Arrays.asList(userRole).stream().map(result -> new SimpleGrantedAuthority(result.getRoleName())).collect(Collectors.toList());
    }

    public String getUserId(){
        return (String)super.getPrincipal();
    }

}

