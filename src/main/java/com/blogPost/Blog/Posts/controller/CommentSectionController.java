package com.blogPost.Blog.Posts.controller;


import com.blogPost.Blog.Posts.entity.CommentSection;
import com.blogPost.Blog.Posts.service.CommentSectionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin("http://localhost:4200")
public class CommentSectionController {

    private final CommentSectionService commentSectionService;

    public CommentSectionController(CommentSectionService commentSectionService){
        this.commentSectionService = commentSectionService;
    }


    @PostMapping("/comments")
    public ResponseEntity<?> createComment(@RequestParam Long postId, @RequestBody CommentSection comments) {
        try{
            return ResponseEntity.ok(commentSectionService.createComment(postId, comments));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
    }

}
