package com.example.resource.api;

import com.example.resource.api.request.post.AddPost;
import com.example.resource.api.response.MsgConstant;
import com.example.resource.api.response.ResponseDto;
import com.example.resource.api.response.ResponseStatus;
import com.example.resource.api.response.post.DetailPost;
import com.example.resource.api.response.post.PostList;
import com.example.resource.domain.post.Post;
import com.example.resource.domain.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<ResponseDto> findAll(@RequestParam(value = "pageCount", required = false, defaultValue = "0") int pageCount) {
        return new ResponseEntity<ResponseDto>(
                ResponseDto
                        .builder()
                        .msg(MsgConstant.SEARCH_SUCCESS)
                        .status(ResponseStatus.SUCCESS)
                        .data(postService.selectAll(pageCount))
                        .build(),
                HttpStatus.OK
        );
    }

    @RequestMapping(value = "/{userName}", method = RequestMethod.GET)
    public ResponseEntity<ResponseDto> findByUserName(@PathVariable("userName") String userName,@RequestParam(value = "pageCount", required = false, defaultValue = "0") int pageCount) {
        return new ResponseEntity<ResponseDto>(
                ResponseDto
                        .builder()
                        .msg(MsgConstant.SEARCH_SUCCESS)
                        .status(ResponseStatus.SUCCESS)
                        .data(postService.selectByUsername(userName,pageCount))
                        .build(),
                HttpStatus.OK
        );
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<ResponseDto> savePost(@RequestBody AddPost addPost) {
        return new ResponseEntity<ResponseDto>(
                ResponseDto
                        .builder()
                        .msg(MsgConstant.SAVE_SUCCESS)
                        .status(ResponseStatus.SUCCESS)
                        .data(postService.save(addPost))
                        .build(),
                HttpStatus.CREATED
        );
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<ResponseDto> postUpdate(@RequestBody Post post) {
        return new ResponseEntity<ResponseDto>(
                ResponseDto
                        .builder()
                        .msg(MsgConstant.UPDATE_SUCCESS)
                        .status(ResponseStatus.SUCCESS)
                        .data(postService.update(post))
                        .build(),
                HttpStatus.OK
        );
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ResponseDto> deletePost(@PathVariable("id") Long id) {
        postService.deleted(id);
        return new ResponseEntity<ResponseDto>(
                ResponseDto
                        .builder()
                        .status(ResponseStatus.SUCCESS)
                        .msg(MsgConstant.DELETED_SUCCESS)
                        .build()
                , HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ResponseDto> findById(@PathVariable("id") Long id){
        return new ResponseEntity<ResponseDto>(
                ResponseDto
                        .builder()
                        .msg(MsgConstant.SEARCH_SUCCESS)
                        .status(ResponseStatus.SUCCESS)
                        .data(postService.selectById(id))
                        .build(),
                HttpStatus.OK
        );
    }
}
