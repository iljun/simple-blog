package com.example.resource.api.response.post;

import com.example.resource.domain.comment.Comment;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class DetailPost {
    private Long id;
    private String title;
    private String content;
    private String username;
    private LocalDateTime modifiedAt;
    private List<Comment> commentList;
}
