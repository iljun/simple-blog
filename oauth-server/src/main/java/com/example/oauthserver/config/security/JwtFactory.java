package com.example.oauthserver.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

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
    private static String signingKey = "jwttest";

    private static final String ISSUER = "simple-blog";


    public String generateToken(MemberContext memberContext) {

        String token = null;



        try {
            token = JWT.create()
                    .withIssuer(ISSUER)
                    .withClaim("user_id", memberContext.getMember().getId())
                    .sign(generateAlgorithm());

        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return token;
    }

    private Algorithm generateAlgorithm() throws UnsupportedEncodingException{
        return Algorithm.HMAC256(signingKey);
    }
}
