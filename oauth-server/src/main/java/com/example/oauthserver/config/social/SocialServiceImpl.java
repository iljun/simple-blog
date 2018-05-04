package com.example.oauthserver.config.social;

import com.example.oauthserver.advice.BadRequest;
import com.example.oauthserver.api.request.github.GithubAccessToken;
import com.example.oauthserver.api.request.google.GoogleProfile;
import com.example.oauthserver.api.response.github.GithubUserProfile;
import com.example.oauthserver.domain.member.Member;
import com.example.oauthserver.domain.member.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 4. 29
 * Time: 오후 12:01
 */
@Service
@Slf4j
public class SocialServiceImpl implements SocialService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MemberService memberService;

    @Value("${github.accessTokenUrl}")
    private String accessTokenUrl;

    @Value("${github.userProfileUrl}")
    private String userProfileUrl;

    @Value("${spring.social.github.appId}")
    private String clientId;

    @Value("${spring.social.github.appSecret}")
    private String clientSecret;

    @Override
    public Member githubSignIn(String code) {

        String accessToken = getAccessToken(code);

        GithubUserProfile profile = getUserProfile(accessToken);

        return memberService.githubSignUp(profile);//정보 가져오기 성공
    }

    private String getAccessToken(String code){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> req_payload = new HashMap<>();
        req_payload.put("client_id", clientId);
        req_payload.put("client_secret", clientSecret);
        req_payload.put("code", code);

        HttpEntity<?> request = new HttpEntity<>(req_payload, httpHeaders);

        ResponseEntity<GithubAccessToken> accessTokenResponseEntity = restTemplate.postForEntity(accessTokenUrl, request, GithubAccessToken.class);

        Optional<String> accessToken = Optional.ofNullable(accessTokenResponseEntity.getBody().getAccess_token());

        accessToken.orElseThrow(() -> new RuntimeException("AccessToken 발급 실패"));

        return accessToken.get();
    }

    private GithubUserProfile getUserProfile(String accessToken){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "token " + accessToken);

        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<GithubUserProfile> githubUserProfileResponseEntity = restTemplate.exchange(userProfileUrl, HttpMethod.GET, entity, GithubUserProfile.class);//프로필 얻어오기

        Optional<GithubUserProfile> profile = Optional.ofNullable(githubUserProfileResponseEntity.getBody());

        profile.orElseThrow(() -> new RuntimeException("프로필 조회 실패"));

        return profile.get();
    }

    @Override
    public Member googleSignIn(GoogleProfile googleProfile) {
        GoogleProfile profile = googleProfile;
        //Google서버에 올바른 토큰인지 검증 --> DB조회후 member 리턴
        if(validityToken(profile.getToken())){


        }
        throw new BadRequest("유효한 경로로 접근하지 않았습니다.");
    }

    private boolean validityToken(String token){
        // google API 호출
        return true;
    }
}