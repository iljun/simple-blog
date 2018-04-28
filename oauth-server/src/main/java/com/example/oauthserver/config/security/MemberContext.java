package com.example.oauthserver.config.security;

import com.example.oauthserver.domain.member.Member;
import com.example.oauthserver.domain.member.UserRole;
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
 * Date : 18. 4. 27
 * Time: 오후 6:58
 */
public class MemberContext extends User {

    private Member member;

    public MemberContext(Member member, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.member = member;
    }

    public static MemberContext formMemberModel(Member member){
        return new MemberContext(member,member.getUsername(),member.getPassword(),parseAuthorities(member.getUserRole()));
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
