package com.example.oauthserver.domain.member;

import com.example.oauthserver.api.request.AddMember;
import com.example.oauthserver.api.response.github.GithubUserProfile;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface MemberService {

    void singUp(AddMember addMember);

    Member githubSignUp(GithubUserProfile githubUserProfile);
}
