//package com.example.oauthserver.domain.security;
//
//import com.example.blog.domain.role.Role;
//import com.example.blog.domain.user.User;
//import lombok.Data;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//
//@Data
//public class LoginUser implements UserDetails{
//
//    private Long id;
//    private String username;
//    private String password;
//    private Collection<Role> roles;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Collection<GrantedAuthority> authorities = new ArrayList<>();
//        for(Role role : roles){
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//        }
//        return authorities;
//    }
//
//    public LoginUser(User user){
//        this.id = user.getId();
//        this.username = user.getName();
//        this.password = user.getPassword();
//        this.roles = user.getRoles();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//}
