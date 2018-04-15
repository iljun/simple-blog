package com.example.blog.api;

import com.example.blog.domain.common.ResponseDto;
import com.example.blog.domain.post.PageListDto;
import com.example.blog.domain.post.Post;
import com.example.blog.domain.post.PostSaveDto;
import com.example.blog.domain.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "" , method = RequestMethod.GET)
    public ResponseEntity<PageListDto> getList(@RequestParam(name = "pageCount",required = false, defaultValue = "1") Integer pageCount){

        return null;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<ResponseDto> addPost(@RequestBody PostSaveDto postSaveDto){
        postService.save(postSaveDto);
        return new ResponseEntity(ResponseDto.builder().msg("OK").build(),HttpStatus.OK);
    }
}
