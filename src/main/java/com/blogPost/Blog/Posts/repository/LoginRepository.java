package com.blogPost.Blog.Posts.repository;

import com.blogPost.Blog.Posts.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
}
