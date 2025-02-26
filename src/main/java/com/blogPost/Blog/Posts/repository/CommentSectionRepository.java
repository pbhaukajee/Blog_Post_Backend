package com.blogPost.Blog.Posts.repository;

import com.blogPost.Blog.Posts.entity.CommentSection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentSectionRepository extends JpaRepository<CommentSection, Long> {
}
