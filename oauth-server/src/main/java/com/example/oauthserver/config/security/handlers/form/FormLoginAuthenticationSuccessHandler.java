package com.example.oauthserver.config.security.handlers.form;

import com.example.oauthserver.api.response.MsgConstant;
import com.example.oauthserver.api.response.ResponseDto;
import com.example.oauthserver.config.security.JwtFactory;
import com.example.oauthserver.config.security.MemberContext;
import com.example.oauthserver.config.security.tokens.form.PostAuthorizationToken;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 4. 27
 * Time: 오후 7:07
 */
@Component
public class FormLoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private JwtFactory jwtFactory;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        PostAuthorizationToken token = (PostAuthorizationToken)authentication;

        MemberContext memberContext = (MemberContext) token.getPrincipal();

        String jwtToken = jwtFactory.generateToken(memberContext);

        processResponse(httpServletResponse, writeDto(jwtToken));
    }


    private ResponseDto writeDto(String jwtToken) throws JsonProcessingException{
        return ResponseDto
                .builder()
                .status(HttpStatus.OK)
                .msg(MsgConstant.LOGIN_SUCCESS)
                .data(objectMapper.writeValueAsString(jwtToken))
                .build();
    }

    private void processResponse(HttpServletResponse httpServletResponse, ResponseDto dto) throws JsonProcessingException, IOException {
        httpServletResponse
                .setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

        httpServletResponse
                .setStatus(HttpStatus.OK.value());

        httpServletResponse
                .getWriter()
                .write(dto.toString());
    }
}
