package com.blogPost.Blog.Posts.service;


import com.blogPost.Blog.Posts.entity.CommentSection;
import com.blogPost.Blog.Posts.entity.Post;
import com.blogPost.Blog.Posts.repository.CommentSectionRepository;
import com.blogPost.Blog.Posts.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.Optional;

@Service
public class CommentSectionService {

    private final CommentSectionRepository commentSectionRepository;
    private final PostRepository postRepository;

    public CommentSectionService(CommentSectionRepository commentSectionRepository, PostRepository postRepository){
        this.commentSectionRepository = commentSectionRepository;
        this.postRepository = postRepository;
    }

    public CommentSection createComment(Long postId, String postedBy, String comment){
        Optional<Post> optionalPost = postRepository.findById(postId);
        if(optionalPost.isPresent()){
            CommentSection commentSection = new CommentSection();
            commentSection.setPost(optionalPost.get());
            commentSection.setComment(comment);
            commentSection.setPostedBy(postedBy);
            commentSection.setCreatedAt(new Date());

            return commentSectionRepository.save(commentSection);

        }else{
            throw new EntityNotFoundException("Post not found");
        }
    }


}
