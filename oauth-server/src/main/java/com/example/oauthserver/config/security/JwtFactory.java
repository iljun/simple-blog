package com.example.oauthserver.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.oauthserver.advice.JwtException;
import com.example.oauthserver.api.response.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

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

    @Value("${password}")
    private String password;

    public String generateToken(MemberContext memberContext) {

        String token = null;

        try {
            token = JWT.create()
                    .withIssuer(ISSUER)
                    .withClaim("user_id", memberContext.getMember().getId())
//                    .sign(Algorithm.HMAC256(getPrivate(getKeyPair())));
                    .sign(generateAlgorithm());
        } catch (Exception e) {
            log.error("jwt 암호화 실패");
            throw new JwtException("jwt 암호화 실패");
        }

        return token;
    }

    private Algorithm generateAlgorithm() throws UnsupportedEncodingException{
//        return Algorithm.HMAC256(getPrivate(getKeyPair()).toString());
        return Algorithm.HMAC256(signingKey);
    }

    private KeyPair getKeyPair() {
        KeyPair keyPair = new KeyStoreKeyFactory(
                new ClassPathResource("jwt.key"), password.toCharArray()
        ).getKeyPair("blog", password.toCharArray());
        return keyPair;
    }

    private String getPrivate(KeyPair keyPair){
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
        return rsaPrivateKey.getAlgorithm();
    }

    private String getPublic(KeyPair keyPair){
        RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
        return rsaPublicKey.getAlgorithm();
    }
}
