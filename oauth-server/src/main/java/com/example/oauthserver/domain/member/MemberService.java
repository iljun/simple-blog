package com.example.oauthserver.domain.member;

import com.example.oauthserver.api.request.AddMember;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface MemberService {

    void singUp(AddMember addMember);
}
