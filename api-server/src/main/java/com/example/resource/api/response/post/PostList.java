package com.example.resource.api.response.post;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PostList {
    private Long id;
    private String title;
    private String username;
    private LocalDateTime modifiedAt;

}
