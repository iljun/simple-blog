package com.example.resource.api;

import com.example.resource.api.request.post.AddPost;
import com.example.resource.api.response.ResponseDto;
import com.example.resource.api.response.ResponseStatus;
import com.example.resource.domain.post.Post;
import com.example.resource.domain.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<Post>> findAll(){
        return new ResponseEntity<List<Post>>(postService.selectAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{userName}", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByUserName(@PathVariable("userName") String userName){
        return new ResponseEntity<List<Post>>(postService.selectByUsername(userName),HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Post> savePost(@RequestBody AddPost addPost){
        return new ResponseEntity<Post>(postService.save(addPost),HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<Post> postUpdate(@RequestBody Post post){
        return new ResponseEntity<Post>(postService.update(post),HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ResponseDto> deletePost(@PathVariable("id") Long id){
        postService.deleted(id);
        return new ResponseEntity<ResponseDto>(
                ResponseDto
                        .builder()
                        .status(ResponseStatus.SUCCESS)
                        .msg("삭제 성공")
                        .build()
                ,HttpStatus.OK);
    }
}
