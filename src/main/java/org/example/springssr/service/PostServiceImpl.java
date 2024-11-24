package org.example.springssr.service;

import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import org.example.springssr.dto.PostDto;
import org.example.springssr.dto.UserDto;
import org.example.springssr.model.Post;
import org.example.springssr.model.User;
import org.example.springssr.repository.PostRepo;
import org.example.springssr.util.ColorUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public record PostServiceImpl(
        PostRepo postRepo,
        UserService userService
) implements PostService {
    @Override
    public PostDto addPost(String title, String content, String imageUrl, int userId) {
        var post = postRepo.save(Post.builder()
                .title(title)
                .content(content)
                .imageUrl(imageUrl)
                .user(User.builder().id(userId).build())
                .build());
        var user = UserDto.builder()
                .id(userId)
                .username(post.getUser().getUsername())
                .build();

        return PostDto.builder()
                .id(post.getId())
                .title(title)
                .content(content)
                .imageUrl(imageUrl)
                .user(user)
                .build();
    }

    @Override
    public List<PostDto> getAllPosts() {
        return postRepo.findAll()
                .stream().map(post -> {
                    var user = UserDto.builder()
                            .id(post.getUser().getId())
                            .username(post.getUser().getUsername())
                            .build();

                    return PostDto.builder()
                            .id(post.getId())
                            .title(post.getTitle())
                            .content(post.getContent())
                            .imageUrl(post.getImageUrl())
                            .user(user)
                            .build();
                })
                .toList();
    }

    @PostConstruct
    public void init() {
        Faker faker = new Faker();

        userService.getAllUsers().forEach(userDto -> {
            for (int i = 0; i < 10; i++) {
                addPost(
                        faker.name().title(),
                        String.join(" ", faker.lorem().words(1000)),
                        "https://placehold.co/600x400/" + ColorUtil.randomColor() + "/" + ColorUtil.randomColor() + "/png",
                        userDto.id()
                );
            }
        });
    }
}
