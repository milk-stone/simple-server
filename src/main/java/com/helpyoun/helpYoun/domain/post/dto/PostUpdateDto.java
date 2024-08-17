package com.helpyoun.helpYoun.domain.post.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostUpdateDto {
    private String title;

    private String body;

    private Boolean published;
}
