package com.SpringApi.SpringApi11.controller;

import com.SpringApi.SpringApi11.payload.PostDto;
import com.SpringApi.SpringApi11.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {


    private PostService postService; // this is interface this is parent of PostServiceImpl

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDto> createDto(@RequestBody PostDto postDto) // this is method
    {
    PostDto dto=postService.createPost(postDto);
    return  new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
}


// return type of public method is RequestEntity
// @RequestBody :- it takes the json object
// PostDto :- PostDto use to custom response can send back