package com.example.blog.domain.post;

public interface PostService {
    PageListDto getPageList(Integer pageCount);
    void save(PostSaveDto postSaveDto);
}
