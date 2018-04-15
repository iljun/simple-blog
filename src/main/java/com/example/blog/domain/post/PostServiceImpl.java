package com.example.blog.domain.post;

import com.example.blog.domain.user.User;
import com.example.blog.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public PageListDto getPageList(Integer pageCount){
//
//        int offset = (pageCount-1)*5;
//        int limit =  (pageCount*5);
//        Pageable limit2 = new PageRequest(0,10);
//        Page<Post> list = postRepository.findAll(limit2);
//        System.out.println(list.toString());
        return null;
    }

    @Override
    public void save(PostSaveDto postSaveDto){
        Post post = Post.builder()
                        .title(postSaveDto.getTitle())
                        .content(postSaveDto.getContent())
                        .user(userRepository.findOne(postSaveDto.getUserId()))
                        .build();
        postRepository.save(post);
    }
}
