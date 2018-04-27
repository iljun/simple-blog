package com.example.oauthserver.domain.member;

import lombok.Getter;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 4. 27
 * Time: 오후 6:42
 */
@Getter
public enum UserRole {

    USER("ROLE_USER"), ADMIN("ROLE_ADMIN") ;

    private String roleName;

    UserRole(String roleName) {
        this.roleName = roleName;
    }

}
