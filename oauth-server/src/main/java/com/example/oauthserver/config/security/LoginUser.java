package com.example.oauthserver.config.security;

import com.example.oauthserver.domain.member.Member;
import com.example.oauthserver.domain.role.Role;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class LoginUser implements UserDetails {

    private static final long serialVersionUID = 6396079419309274853L;
    private Long id;
    private String username;
    private String password;
    private Collection<Role> roles;

    public LoginUser() {
    }

    public LoginUser(Member member) {
        this.id = member.getId();
        this.username =  member.getUsername();
        this.password = member.getPassword();
        this.roles = member.getRoles();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }

}
