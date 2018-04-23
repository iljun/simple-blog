package com.example.resource.api.request.post;

import lombok.Data;

@Data
public class UpdatePost {
    private Long id;
    private String title;
    private String content;
    private String userName;
}
