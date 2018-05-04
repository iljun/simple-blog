package com.example.resource.config.security;

import com.example.resource.config.security.tokens.JwtPostProcessingToken;
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
 * Date : 18. 5. 1
 * Time: 오전 10:52
 */
public class MemberContext extends User{

    private Member member;

    public MemberContext(Member member, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.member = member;
    }

    public static MemberContext formMemberModel(Member member){
        return new MemberContext(member,member.getUsername(),member.getPassword(),parseAuthorities(member.getUserRole()));
    }

    public static MemberContext fromJwtPostProcessingToken(JwtPostProcessingToken token){
        return new MemberContext(null,token.getUserId(),null,token.getAuthorities());
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
