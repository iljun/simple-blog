package com.example.oauthserver.domain.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Optional;

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private Optional<String> username;

    @Column(name = "password")
    private Optional<String> password;

    @Column(name = "email")
    private Optional<String> email;

    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Column(name = "social_id")
    private Optional<Long> socialId;

    @Column(name = "social_profile")
    private Optional<String> socialProfile;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Optional<String> getUsername() {
        return this.getUsername();
    }

    public void setUsername(String username) {
        this.username = Optional.ofNullable(username);
    }

    public Optional<String> getPassword() {
        return this.getPassword();
    }

    public void setPassword(String password) {
        this.password = Optional.ofNullable(password);
    }

    public Optional<String> getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = Optional.ofNullable(email);
    }

    public UserRole getUserRole() {
        return this.userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public void setSocialId(Long socialId){
        this.socialId = Optional.ofNullable(socialId);
    }

    public Optional<Long> getSocialId(){
        return this.socialId;
    }

    public void setSocialProfile(String socialProfile){
        this.socialProfile = Optional.ofNullable(socialProfile);
    }

    public Optional<String> getSocialProfile(){
        return this.socialProfile;
    }
}
