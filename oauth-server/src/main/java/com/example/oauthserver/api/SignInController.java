package com.example.oauthserver.api;

import com.example.oauthserver.api.request.AccessToken;
import com.example.oauthserver.api.response.ResponseDto;
import com.example.oauthserver.config.social.SocialService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 4. 29
 * Time: 오전 11:58
 */
@RestController
@RequestMapping("/api/signIn")
@Slf4j
public class SignInController {

    @Autowired
    private SocialService socialService;

    @RequestMapping(value = "/github", method = RequestMethod.GET)
    public ResponseEntity<ResponseDto> githubSignIn(@RequestParam("code") String code){
        log.info(socialService.githubSignIn(code).toString());//User 정보 저장
        //TODO Server요청이 아닌 client요청으로 변경
        //TODO jwt로 변환해 저장
        return null;
    }
}
