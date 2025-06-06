package com.microservice.post.controller;

import com.microservice.post.entity.Post;
import com.microservice.post.payload.PostDto;
import com.microservice.post.service.PostService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<Post> savePost(@RequestBody Post post) {
        Post newPost = postService.savePost(post);
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }

    //http://localhost:8081/api/posts/{postId}
    @GetMapping("/{postId}")
    public Post getPostByPostId(@PathVariable String postId) {
        Post post = postService.findPostById(postId);
        return post;
    }

    //http://localhost:8081/api/posts/{postId}/comments
    @GetMapping("/{postId}/comments")
    @CircuitBreaker(name="commentBreaker", fallbackMethod = "commentFallback")
    public ResponseEntity<PostDto> getPostWithComments(@PathVariable String postId) {
        PostDto postDto = postService.getPostWithComments(postId);
        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }

    public ResponseEntity<PostDto> commentFallback(String postId, Throwable throwable) {
        PostDto fallbackDto = new PostDto();
        fallbackDto.setPostId(postId);
        fallbackDto.setTitle("Fallback Title");
        fallbackDto.setDescription("Comment Service is down. Showing post only.");
        fallbackDto.setComments(List.of()); // return empty comment list

        return new ResponseEntity<>(fallbackDto, HttpStatus.OK);
    }

}
