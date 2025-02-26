package com.blogPost.Blog.Posts.controller;

import com.blogPost.Blog.Posts.entity.Post;
import com.blogPost.Blog.Posts.service.PostService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")

@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody Post post){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(postService.savePost(post));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(postService.getAllPosts());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{postId}")
    public ResponseEntity<?> getPostById(@PathVariable Long postId){
        try{
            return ResponseEntity.ok(postService.getPostById(postId));
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
