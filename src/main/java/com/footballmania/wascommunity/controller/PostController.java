package com.footballmania.wascommunity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.footballmania.wascommunity.dto.PostResponseDto;
import com.footballmania.wascommunity.service.PostService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://localhost:5500"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    // get all posts
    @GetMapping("/all")
    public ResponseEntity<List<PostResponseDto>> getAllPost() {

        return ResponseEntity.ok(postService.getAllPost());
    }

}
