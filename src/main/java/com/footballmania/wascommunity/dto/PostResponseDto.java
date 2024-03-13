package com.footballmania.wascommunity.dto;

import com.footballmania.wascommunity.entity.Post;

import lombok.Getter;

@Getter
public class PostResponseDto {
    private Long id;
    private String uuid;
    private String title;
    private String text;
    private String user;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.uuid = post.getUuid();
        this.title = post.getTitle();
        this.text = post.getText();
        this.user = post.getUser().getName();
    }

}
