package com.example.oauthserver.config.security;

import com.example.oauthserver.domain.member.Member;
import com.example.oauthserver.domain.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserDetailService implements UserDetailsService { // 실제 DB저장된 사용자 정보 조회

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(username);
        if (member == null) {
            throw new UsernameNotFoundException("Username not fount : " + username);
        }

        LoginUser loginUser = createUser(member);
        return loginUser;
    }

    public LoginUser createUser(Member member) {
        return new LoginUser(member);
    }
}
