package com.example.resource.domain.comment;

import com.example.resource.api.request.comment.AddComment;
import com.example.resource.api.request.comment.UpdateComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void save(AddComment addComment){
        Comment saveComment = Comment
                                .builder()
                                .content(addComment.getContent())
//                                .postId(addComment.getPostId())
                                .build();
        commentRepository.save(saveComment);
    }

    @Override
    public void update(UpdateComment updateComment){
        Comment saveComment = Comment
                                .builder()
                                .id(updateComment.getId())
                                .content(updateComment.getContent())
//                                .postId(updateComment.getPostId())
                                .build();
        commentRepository.save(saveComment);
    }

    @Override
    public void deleted(Long id){
        Comment deletedComment = commentRepository.findOne(id);
        deletedComment.deleted();
        commentRepository.save(deletedComment);
    }
}
