package com.example.resource.config.security.filters;

import com.example.resource.config.security.HeaderTokenExtractor;
import com.example.resource.config.security.handlers.JwtAuthenticationFailureHandler;
import com.example.resource.config.security.tokens.JwtPreProcessingToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 1
 * Time: 오전 10:20
 */
@Slf4j
public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private static final String HEADER_FREFIX = "Authorization";

    private JwtAuthenticationFailureHandler jwtAuthenticationFailureHandler;

    protected JwtAuthenticationFilter(RequestMatcher requiresAuthenticationRequestMatcher) {
        super(requiresAuthenticationRequestMatcher);
    }

    public JwtAuthenticationFilter(RequestMatcher requestMatcher, JwtAuthenticationFailureHandler jwtAuthenticationFailureHandler){
        this(requestMatcher);
        this.jwtAuthenticationFailureHandler = jwtAuthenticationFailureHandler;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {

        String tokenPayload = httpServletRequest.getHeader(HEADER_FREFIX);

        JwtPreProcessingToken token = new JwtPreProcessingToken(tokenPayload);

        return super.getAuthenticationManager().authenticate(token);
    }

    //토큰 유효성 일치
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        SecurityContext securityContext = SecurityContextHolder.createEmptyContext();

        securityContext.setAuthentication(authResult);

        SecurityContextHolder.setContext(securityContext);

        chain.doFilter(request,response);
    }

    // 인증 실패(올바른 토큰이 아닌경우) -> Jwt용 ExceptionHandler
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        SecurityContextHolder.clearContext();//Context를 삭제 인증에 실패했기 때문에

        this.jwtAuthenticationFailureHandler.onAuthenticationFailure(request,response,failed);
    }

}
