package com.example.resource.domain.comment;

import com.example.resource.advice.BadRequest;
import com.example.resource.api.request.comment.AddComment;
import com.example.resource.api.request.comment.UpdateComment;
import com.example.resource.domain.post.Post;
import com.example.resource.domain.post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void save(AddComment addComment){
        Optional<Post> post = postRepository.findById(addComment.getPostId());

        post.orElseThrow(() -> new BadRequest("존재하지 않는 게시물에는 댓글 등록이 불가능합니다."));

        Comment saveComment = Comment
                                .builder()
                                .content(addComment.getContent())
                                .post(post.get())
                                .build();
        commentRepository.save(saveComment);
    }

    @Override
    public void update(UpdateComment updateComment){
        Optional<Post> post = postRepository.findById(updateComment.getPostId());

        post.orElseThrow(() -> new BadRequest("존재하지 않은 게시물 입니다."));

        Comment saveComment = Comment
                                .builder()
                                .id(updateComment.getId())
                                .content(updateComment.getContent())
                                .post(post.get())
                                .build();
        commentRepository.save(saveComment);
    }

    @Override
    public void deleted(Long id){
        Optional<Comment> deletedComment = commentRepository.findById(id);

        deletedComment.orElseThrow(() -> new BadRequest("존재하지 않는 댓글입니다."));

        deletedComment.get().deleted();
        commentRepository.save(deletedComment.get());
    }
}
