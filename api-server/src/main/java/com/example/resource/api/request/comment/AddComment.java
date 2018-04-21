package com.example.resource.api.request.comment;

import lombok.Data;

@Data
public class AddComment {
    private String content;
    private Long postId;
}
