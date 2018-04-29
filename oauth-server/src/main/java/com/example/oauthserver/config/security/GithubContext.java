package com.example.oauthserver.config.security;

import com.example.oauthserver.domain.member.Member;
import com.example.oauthserver.domain.member.UserRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 4. 29
 * Time: 오후 3:11
 */
@Slf4j
public class GithubContext extends User{

    private Member member;

    public GithubContext(Member member, String username, String email, Collection<? extends GrantedAuthority> authorities) {
        super(username, email, authorities);
        log.info(member.toString());
        this.member = member;
    }

    public static GithubContext formMemberModel(Member member){
        return new GithubContext(member,member.getUsername(),member.getEmail(),parseAuthorities(member.getUserRole()));
    }

    private static List<SimpleGrantedAuthority> parseAuthorities(UserRole role){
        return Arrays
                .asList(role)
                .stream()
                .map(r -> new SimpleGrantedAuthority(r.getRoleName()))
                .collect(Collectors.toList());
    }

    public Member getMember(){
        return this.member;
    }
}
