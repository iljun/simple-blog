package com.example.resource.api.request.comment;

import lombok.Data;

@Data
public class UpdateComment {
    private Long id;
    private String content;
    private Long postId;
}
