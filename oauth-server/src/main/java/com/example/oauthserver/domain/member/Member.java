package com.example.oauthserver.domain.member;

import lombok.*;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Column(name = "social_id")
    private Long socialId;

    @Column(name = "social_profile")
    private String socialProfile;

}
