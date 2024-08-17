package com.helpyoun.helpYoun.domain.post.dto;

import com.helpyoun.helpYoun.domain.post.entity.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class PostResponseDto {
    private String title;

    private String body;

    private Boolean published;

    private LocalDateTime createdAt;

    public PostResponseDto(Post post) {
        this.title = post.getTitle();
        this.body = post.getBody();
        this.published = post.getPublished();
        this.createdAt = post.getCreatedAt();
    }
}
