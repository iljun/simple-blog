package com.example.resource.domain.post;

import com.example.resource.api.request.post.AddPost;
import com.example.resource.api.response.post.DetailPost;
import com.example.resource.api.response.post.PostList;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PostService {
    List<PostList> selectAll(int pageCount);

    List<PostList> selectByUsername(String username, int pageCount);

    void deleted(Long id);

    DetailPost update(Post post);

    DetailPost save(AddPost addPost);

    DetailPost selectById(Long id);
}
