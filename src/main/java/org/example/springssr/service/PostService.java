package org.example.springssr.service;

import org.example.springssr.dto.PostDto;

import java.util.List;

public interface PostService {
    PostDto addPost(String title, String content, String imageUrl, int userId);
    List<PostDto> getAllPosts();
}
