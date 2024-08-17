package com.helpyoun.helpYoun.domain.post.controller;

import com.helpyoun.helpYoun.domain.post.dto.PostRequestDto;
import com.helpyoun.helpYoun.domain.post.dto.PostResponseDto;
import com.helpyoun.helpYoun.domain.post.dto.PostUpdateDto;
import com.helpyoun.helpYoun.domain.post.dto.ResponseSuccessful;
import com.helpyoun.helpYoun.domain.post.entity.Post;
import com.helpyoun.helpYoun.domain.post.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @Operation(summary = "모든 게시글 불러오기")
    @GetMapping
    public ResponseEntity<List<PostResponseDto>> getAllPosts(Pageable pageable) {
        Page<PostResponseDto> posts = postService.getAllPosts(pageable);
        return ResponseEntity.ok(posts.getContent());
    }

    @Operation(summary = "특정 게시글 불러오기")
    @GetMapping("/{postId}")
    public ResponseEntity<PostResponseDto> getPostById(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.getPostById(postId));
    }

    @Operation(summary = "게시글 등록하기")
    @PostMapping
    public ResponseEntity<ResponseSuccessful> createPost(@RequestBody PostRequestDto postRequestDto) {
        return ResponseEntity.ok(postService.createPost(postRequestDto));
    }

    @Operation(summary = "특정 게시글 수정하기")
    @PutMapping("/{postId}")
    public ResponseEntity<ResponseSuccessful> updatePost(@PathVariable Long postId, @RequestBody PostUpdateDto postUpdateDto) {
        return ResponseEntity.ok(postService.updatePost(postId, postUpdateDto));
    }

    @Operation(summary = "특정 게시글 삭제하기")
    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return ResponseEntity.noContent().build();
    }

}
