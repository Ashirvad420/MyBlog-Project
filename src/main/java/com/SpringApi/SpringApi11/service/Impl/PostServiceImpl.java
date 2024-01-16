package com.SpringApi.SpringApi11.service.Impl;
import com.SpringApi.SpringApi11.entity.Post;
import com.SpringApi.SpringApi11.payload.PostDto;
import com.SpringApi.SpringApi11.repository.PostRepository;
import com.SpringApi.SpringApi11.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService { // here we call the PostService

    private PostRepository postRepository;  // here we will call repository interface

   // it can create generated constructor Base Dependency
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {

        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post savedPost= postRepository.save(post);  // To save Data using  postRepository


        PostDto dto = new PostDto(); // Return PostDto
        dto.setTitle(savedPost.getTitle());
        dto.setDescription(savedPost.getDescription());
        dto.setContent(savedPost.getContent());
        return dto;
    }
}

// write a code save the data into database

// we can not use autowired for dependency it can create generated constructor Dependency