package com.blogPost.Blog.Posts.service;

import com.blogPost.Blog.Posts.entity.Post;
import com.blogPost.Blog.Posts.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final CommentSectionService commentSectionService;

    public PostService(PostRepository postRepository, CommentSectionService commentSectionService){
        this.postRepository = postRepository;
        this.commentSectionService = commentSectionService;
    }

    public Post savePost(Post post){
        post.setLikeCount(0);
        post.setViewCount(0);
        post.setDate(new Date());

        return postRepository.save(post);
    }

    //List all post
    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }


    //Update viewCount
    public Post getPostById(Long postId){
        Optional<Post> optionalPost = postRepository.findById(postId);
        if(optionalPost.isPresent()){
            Post post = optionalPost.get();
            post.setViewCount(post.getViewCount() + 1);
            return postRepository.save(post);
        }else{
            throw  new EntityNotFoundException("Post not found");
        }
    }

    //Update likeCount
    public void likePost(Long postId){
        Optional<Post> optionalPost = postRepository.findById((postId));
        if(optionalPost.isPresent()){
            Post post = optionalPost.get();
            post.setLikeCount(post.getLikeCount() + 1);
            postRepository.save(post);
        }else{
            throw new EntityNotFoundException("Post not found");
        }
    }

    //Search post by title
    public List<Post> findByTitle(String title){
        return postRepository.findByTitleContainingIgnoreCase(title);
    }

    //Delete Post
    @Transactional
    public String deletePostById(Long postId){
        Optional<Post> optionalPost = postRepository.findById(postId);
        if(optionalPost.isPresent()){
            Post post = optionalPost.get();
            postRepository.delete(post);
            return "Post deleted successfully";
        }else{
            throw new EntityNotFoundException("Post not found");
        }
    }
}
