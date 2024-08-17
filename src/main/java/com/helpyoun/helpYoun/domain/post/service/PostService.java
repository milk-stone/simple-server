package com.helpyoun.helpYoun.domain.post.service;

import com.helpyoun.helpYoun.domain.post.dto.PostRequestDto;
import com.helpyoun.helpYoun.domain.post.dto.PostResponseDto;
import com.helpyoun.helpYoun.domain.post.dto.PostUpdateDto;
import com.helpyoun.helpYoun.domain.post.dto.ResponseSuccessful;
import com.helpyoun.helpYoun.domain.post.entity.Post;
import com.helpyoun.helpYoun.domain.post.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public Page<PostResponseDto> getAllPosts(Pageable pageable){
        Page<Post> posts = postRepository.findAll(pageable);
        return posts.map(PostResponseDto::new);
    }

    public PostResponseDto getPostById(Long id){
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found."));
        return new PostResponseDto(post);
    }

    @Transactional
    public ResponseSuccessful createPost(PostRequestDto postRequestDto){
        Post post = Post.toEntity(postRequestDto);
        postRepository.save(post);
        return ResponseSuccessful.builder().success(true).build();
    }

    @Transactional
    public ResponseSuccessful updatePost(Long id, PostUpdateDto postUpdateDto){
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found."));
        post.update(postUpdateDto);
        postRepository.save(post);
        return ResponseSuccessful.builder().success(true).build();
    }

    public void deletePost(Long postId){
        postRepository.deleteById(postId);
    }
}
