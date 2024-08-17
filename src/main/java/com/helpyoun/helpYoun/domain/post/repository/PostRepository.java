package com.helpyoun.helpYoun.domain.post.repository;

import com.helpyoun.helpYoun.domain.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
