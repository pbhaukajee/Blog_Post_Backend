package com.blogPost.Blog.Posts.service;


import com.blogPost.Blog.Posts.entity.CommentSection;
import com.blogPost.Blog.Posts.entity.Post;
import com.blogPost.Blog.Posts.repository.CommentSectionRepository;
import com.blogPost.Blog.Posts.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.annotations.Comments;
import org.springframework.stereotype.Service;


import java.security.PublicKey;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentSectionService {

    private final CommentSectionRepository commentSectionRepository;
    private final PostRepository postRepository;

    public CommentSectionService(CommentSectionRepository commentSectionRepository, PostRepository postRepository){
        this.commentSectionRepository = commentSectionRepository;
        this.postRepository = postRepository;
    }


    public CommentSection createComment(Long postId, CommentSection comments){
        Optional<Post> optionalPost = postRepository.findById(postId);
        if(optionalPost.isPresent()){
            comments.setPost(optionalPost.get());
            comments.setComment(comments.getComment());
            comments.setPostedBy(comments.getPostedBy());
            comments.setCreatedAt(new Date());

            return commentSectionRepository.save(comments);

        }else{
            throw new EntityNotFoundException("Post not found");
        }
    }

    public List<CommentSection> getCommentsByPostId(Long postId){
        return commentSectionRepository.findByPostId(postId);
    }


}
