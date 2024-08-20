package com.helpyoun.helpYoun.domain.post.dto;

import com.helpyoun.helpYoun.domain.post.entity.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class PostResponseDto {
    private Long id;

    private String title;

    private String body;

    private Boolean publish;

    private LocalDateTime createdAt;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.body = post.getBody();
        this.publish = post.getPublish();
        this.createdAt = post.getCreatedAt();
    }
}
