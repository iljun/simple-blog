package com.example.resource.domain.comment;

import com.example.resource.api.request.comment.AddComment;
import com.example.resource.api.request.comment.UpdateComment;

public interface CommentService {

    void save(AddComment addcomment);
    void update(UpdateComment updateComment);
    void deleted(Long id);
}
