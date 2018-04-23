package com.example.oauthserver.api.request;

import lombok.Data;

@Data
public class AddMember {
    private String email;
    private String password1;
    private String password2;
    private String username;
}
