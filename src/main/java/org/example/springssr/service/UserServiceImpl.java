package org.example.springssr.service;

import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import org.example.springssr.dto.UserDto;
import org.example.springssr.model.User;
import org.example.springssr.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record UserServiceImpl(
        UserRepo userRepo
) implements UserService {
    @Override
    public UserDto addUser(String username) {
        var user = userRepo.save(User.builder()
                .username(username)
                .build()
        );

        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepo.findAll()
                .stream().map(user ->
                        UserDto.builder()
                                .id(user.getId())
                                .username(user.getUsername())
                                .build()
                ).toList();
    }

    @PostConstruct
    public void init() {
        Faker faker = new Faker();

        for (int i = 0; i < 10; i++) {
            addUser(faker.name().username());
        }
    }
}
