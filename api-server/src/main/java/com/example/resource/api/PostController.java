package com.example.resource.api;

import com.example.resource.api.request.post.AddPost;
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
    public ResponseEntity<List<PostList>> findAll(@RequestParam(value = "pageCount", required = false, defaultValue = "0") int pageCount) {
        return new ResponseEntity<List<PostList>>(
                postService.selectAll(pageCount),
                HttpStatus.OK
        );
    }

    @RequestMapping(value = "/{userName}", method = RequestMethod.GET)
    public ResponseEntity<List<PostList>> findByUserName(@PathVariable("userName") String userName,@RequestParam(value = "pageCount", required = false, defaultValue = "0") int pageCount) {
        return new ResponseEntity<List<PostList>>(
                postService.selectByUsername(userName,pageCount),
                HttpStatus.OK
        );
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<DetailPost> savePost(@RequestBody AddPost addPost) {
        return new ResponseEntity<DetailPost>(
                postService.save(addPost),
                HttpStatus.CREATED
        );
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<DetailPost> postUpdate(@RequestBody Post post) {
        return new ResponseEntity<DetailPost>(
                postService.update(post),
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
                        .msg("삭제 성공")
                        .build()
                , HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<DetailPost> findById(@PathVariable("id") Long id){
        return new ResponseEntity<DetailPost>(
                postService.selectById(id),
                HttpStatus.OK
        );
    }
}
