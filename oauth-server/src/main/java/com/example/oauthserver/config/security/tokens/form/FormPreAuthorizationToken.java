package com.example.oauthserver.config.security.tokens.form;

import com.example.oauthserver.api.request.FormLoginDto;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 4. 27
 * Time: 오후 7:03
 */
public class FormPreAuthorizationToken extends UsernamePasswordAuthenticationToken {

    private FormPreAuthorizationToken(String username, String password) {
        super(username, password);
    }

    public FormPreAuthorizationToken(FormLoginDto dto){
        this(dto.getUsername(),dto.getPassword());
    }
}
