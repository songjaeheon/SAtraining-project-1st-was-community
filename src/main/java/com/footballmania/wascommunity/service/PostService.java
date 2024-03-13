package com.footballmania.wascommunity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import com.footballmania.wascommunity.repository.PostRepository;
import com.footballmania.wascommunity.dto.PostResponseDto;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
    
    @Transactional
    public List<PostResponseDto> getAllPost() {
        List<PostResponseDto> posts = postRepository.findAll().stream().map(PostResponseDto::new).collect(Collectors.toList());
        
        return posts;
    }
}
