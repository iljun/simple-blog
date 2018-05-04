package com.example.oauthserver.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.oauthserver.advice.JwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 4. 27
 * Time: 오후 7:10
 */
@Slf4j
@Component
public class JwtFactory {

    //TODO key로 변경
    @Value("${signingnKey}")
    private String signingKey;

    private static final String ISSUER = "simple-blog";

    @Value("${password}")
    private String password;


    public String generateToken(MemberContext memberContext) {

        String token = null;
        try {
            token = JWT.create()
                    .withIssuer(ISSUER)
                    .withExpiresAt(new Date(new Date().getTime()*1000))
                    .withClaim("user_id", memberContext.getMember().getId())
                    .withClaim("user_name", memberContext.getMember().getUsername())
                    .withClaim("role",memberContext.getMember().getUserRole().toString())
//                    .withJWTId()
                    .sign(generateAlgorithm());
        } catch (Exception e) {
            log.error("jwt 암호화 실패");
            throw new JwtException("jwt 암호화 실패");
        }

        return token;
    }

    public String generateToken(GithubContext githubContext) {
        String token = null;

        try {
            token = JWT.create()
                    .withIssuer(ISSUER)
                    .withClaim("user_id", githubContext.getMember().getId())
                    .withClaim("social", githubContext.getMember().getSocialProfile())
                    .withClaim("user_name", githubContext.getMember().getUsername())
                    .withClaim("role",githubContext.getMember().getUserRole().toString())
                    .withExpiresAt(new Date(new Date().getTime()*1000))
//                    .withJWTId()
                    .sign(generateAlgorithm());
        } catch (Exception e) {
            log.error("jwt 암호화 실패");
            throw new JwtException("jwt 암호화 실패");
        }

        return token;

    }

    private Algorithm generateAlgorithm() throws UnsupportedEncodingException {
        return Algorithm.HMAC256(signingKey);
    }

    public String generateRefreshToken(MemberContext memberContext){

        String token = null;
        try {
            token = JWT.create()
                    .withIssuer(ISSUER)
                    .withExpiresAt(new Date(new Date().getTime()*100000))
                    .withClaim("user_id", memberContext.getMember().getId())
                    .withClaim("user_name", memberContext.getMember().getUsername())
                    .withClaim("role",memberContext.getMember().getUserRole().toString())
//                    .withJWTId()
                    .sign(generateAlgorithm());
        } catch (Exception e) {
            log.error("jwt 암호화 실패");
            throw new JwtException("jwt 암호화 실패");
        }

        return token;
    }
}