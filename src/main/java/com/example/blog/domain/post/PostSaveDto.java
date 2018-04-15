package com.example.blog.domain.post;

import lombok.Data;

@Data
public class PostSaveDto {
    private String title;
    private String content;
    private Long userId;
}
