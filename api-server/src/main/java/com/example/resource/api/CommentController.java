package com.example.resource.api;

import com.example.resource.api.request.comment.AddComment;
import com.example.resource.api.request.comment.UpdateComment;
import com.example.resource.api.response.ResponseDto;
import com.example.resource.api.response.ResponseStatus;
import com.example.resource.domain.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<ResponseDto> commentSave(@RequestBody AddComment addComment){
        commentService.save(addComment);
        return new ResponseEntity<ResponseDto>(
                ResponseDto
                        .builder()
                        .msg("댓글 등록")
                        .status(ResponseStatus.SUCCESS)
                        .build()
                ,HttpStatus.CREATED
        );
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<ResponseDto> commentUpdate(@RequestBody UpdateComment updateComment){
        commentService.update(updateComment);
        return new ResponseEntity<ResponseDto>(
                ResponseDto
                    .builder()
                    .msg("댓글 수정")
                    .status(ResponseStatus.SUCCESS)
                    .build()
                ,HttpStatus.OK
        );
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ResponseDto> commentDelete(@PathVariable("id") Long id){
        commentService.deleted(id);
        return new ResponseEntity<ResponseDto>(
                ResponseDto
                    .builder()
                    .msg("댓글 삭제")
                    .status(ResponseStatus.SUCCESS)
                    .build()
                ,HttpStatus.OK
        );
    }
}
