package com.example.resource.domain.post;

import com.example.resource.api.request.post.AddPost;

import java.util.List;

public interface PostService {
    List<Post> selectAll();
    List<Post> selectByUsername(String username);
    void deleted(Long id);
    Post update(Post post);
    Post save(AddPost addPost);
}
