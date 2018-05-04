package com.example.oauthserver.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 4. 29
 * Time: 오전 11:58
 */
@RestController
@RequestMapping("/google")
@Slf4j
public class SignInController {

    @RequestMapping(value ="/signIn",method = RequestMethod.POST)
    public void test(@RequestBody Object t){
        System.out.println(t.toString());
    }
}