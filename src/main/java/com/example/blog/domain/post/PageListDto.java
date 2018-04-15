package com.example.blog.domain.post;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PageListDto {
    private Long id;
    private String title;
    private LocalDateTime modifiedAt;
    private String modifiedBy;
}
