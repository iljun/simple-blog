package com.example.oauthserver.config.social;

import com.example.oauthserver.api.request.AccessToken;
import com.example.oauthserver.domain.member.Member;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 4. 29
 * Time: 오후 12:00
 */
public interface SocialService {

    Member githubSignIn(String code);
}
