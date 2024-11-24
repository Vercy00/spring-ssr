package org.example.springssr.controller;

import org.example.springssr.dto.PostDto;
import org.example.springssr.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public record PostController(
        PostService postService
) {
    @GetMapping
    public ResponseEntity<List<PostDto>> getAllUsers() {
        return ResponseEntity.ok(postService.getAllPosts());
    }
}
