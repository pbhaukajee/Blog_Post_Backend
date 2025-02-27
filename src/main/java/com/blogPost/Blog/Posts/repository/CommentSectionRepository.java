package com.blogPost.Blog.Posts.repository;

import com.blogPost.Blog.Posts.entity.CommentSection;
import org.hibernate.annotations.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentSectionRepository extends JpaRepository<CommentSection, Long> {

    List<CommentSection> findByPostId(Long postId);

    void deletePostById(Long postId);
}
