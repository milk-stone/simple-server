package com.helpyoun.helpYoun.domain.post.entity;

import com.helpyoun.helpYoun.domain.post.dto.PostRequestDto;
import com.helpyoun.helpYoun.domain.post.dto.PostUpdateDto;
import com.helpyoun.helpYoun.global.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Post extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String body;

    private Boolean published;

    public static Post toEntity(PostRequestDto postRequestDto){
        return Post.builder()
                .title(postRequestDto.getTitle())
                .body(postRequestDto.getBody())
                .published(postRequestDto.getPublished())
                .build();
    }

    public void update(PostUpdateDto postUpdateDto){
        this.title = postUpdateDto.getTitle();
        this.body = postUpdateDto.getBody();
        this.published = postUpdateDto.getPublished();
    }

    @Builder
    public Post(String title, String body, Boolean published) {
        this.title = title;
        this.body = body;
        this.published = published;
    }
}
