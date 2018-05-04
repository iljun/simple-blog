package com.example.resource.config.security;

import lombok.Data;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 1
 * Time: 오전 11:01
 */
@Data
public class Member {
    private Long id;

    private String username;

    private String password;

    private String email;

    private UserRole userRole;

    private Long socialId;

    private String socialProfile;

}
