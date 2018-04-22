package com.example.resource.domain.post;

import com.example.resource.advice.BadRequest;
import com.example.resource.api.request.post.AddPost;
import com.example.resource.api.response.post.DetailPost;
import com.example.resource.api.response.post.PostList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    private static final int PAGESIZE = 5;

    @Override
    public List<PostList> selectAll(int pageCount){
        Page<Post> pageList = postRepository.findAll(new PageRequest(pageCount,PAGESIZE));

        if(pageList.getContent().isEmpty())
            throw new BadRequest("게시물이 더이상 존재하지 않습니다");

        return pageList
                .getContent()
                .stream()
                .map(post -> PostList
                        .builder()
                        .id(post.getId())
                        .title(post.getTitle())
                        .username(post.getUserName())
                        .modifiedAt(post.getModifiedAt())
                        .build()
                ).collect(Collectors.toList());
    }

    @Override
    public List<PostList> selectByUsername(String username,int pageCount){
        Page<Post> pageList = postRepository.findByUserName(username,new PageRequest(pageCount,PAGESIZE));

        if(pageList.getContent().isEmpty())
            throw new BadRequest("게시물이 존재하지 않습니다.");

        return pageList
                .getContent()
                .stream()
                .map(post -> PostList
                        .builder()
                        .id(post.getId())
                        .title(post.getTitle())
                        .username(post.getUserName())
                        .modifiedAt(post.getModifiedAt())
                        .build()
                ).collect(Collectors.toList());
    }

    @Override
    public void deleted(Long id){
        Post deletedPost = postRepository.findOne(id);

        if(deletedPost==null)
            throw new BadRequest("존재하지 않는 게시물입니다.");

        deletedPost.deleted();
        postRepository.save(deletedPost);
    }

    @Override
    public DetailPost update(Post post){
        //TODO Token을 이용한 유효성검사 추가
        Optional<Post> perPost = postRepository.findById(post.getId());
        perPost.orElseThrow(() -> new BadRequest("존재하지않는 게시물입니다."));

        Post updatePost = postRepository.save(post);
        return DetailPost
                .builder()
                .id(updatePost.getId())
                .content(updatePost.getContent())
                .username(updatePost.getUserName())
                .commentList(updatePost.getCommentList().stream().collect(Collectors.toList()))
                .modifiedAt(updatePost.getModifiedAt())
                .build();
    }

    @Override
    public DetailPost save(AddPost addPost){
        //TODO TOKEN적용시 변경
        Post preSavePost = Post.builder()
                .title(addPost.getTitle())
                .content(addPost.getContent())
//                .userName()
                .build();
        Post savePost = postRepository.save(preSavePost);

        return DetailPost
                .builder()
                .id(savePost.getId())
                .title(savePost.getTitle())
                .content(savePost.getContent())
                .modifiedAt(savePost.getModifiedAt())
                .build();
    }

    @Override
    public DetailPost selectById(Long id){
        Optional<Post> post = postRepository.findById(id);

        post.orElseThrow(()->new BadRequest("게시물이 존재하지 않습니다."));

        return DetailPost
                .builder()
                .id(post.get().getId())
                .title(post.get().getTitle())
                .content(post.get().getContent())
                .modifiedAt(post.get().getModifiedAt())
                .username(post.get().getUserName())
                .commentList(post.get().getCommentList().stream().collect(Collectors.toList()))
                .build();
    }
}
