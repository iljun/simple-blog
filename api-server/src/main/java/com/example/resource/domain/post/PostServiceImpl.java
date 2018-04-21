package com.example.resource.domain.post;

import com.example.resource.api.request.post.AddPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> selectAll(){
        return postRepository.findAll();
    }

    @Override
    public List<Post> selectByUsername(String username){
        return postRepository.findByUserName(username);
    }

    @Override
    public void deleted(Long id){
        Post deletedPost = postRepository.findOne(id);
        deletedPost.deleted();
        postRepository.save(deletedPost);
    }

    @Override
    public Post update(Post post){
        Post updatePost = postRepository.save(post);
        return updatePost;
    }

    @Override
    public Post save(AddPost addPost){
        Post savePost = Post.builder()
                .title(addPost.getTitle())
                .content(addPost.getContent())
                .build();
        return postRepository.save(savePost);
    }
}
