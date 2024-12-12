package org.example.springssr.service;

import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import org.example.springssr.dto.UserDto;
import org.example.springssr.dto.req.UserAddReq;
import org.example.springssr.model.User;
import org.example.springssr.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record UserServiceImpl(
        UserRepo userRepo
) implements UserService {
    @Override
    public UserDto addUser(UserAddReq req) {
        var user = userRepo.save(User.builder()
                .username(req.username())
                .surname(req.surname())
                .build()
        );

        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .surname(user.getSurname())
                .build();
    }

    @Override
    public UserDto getUser(int userId) {
        var user = userRepo.findById(userId).orElseThrow(() ->
                new RuntimeException("User not found"));

        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .surname(user.getSurname())
                .build();
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepo.findAll()
                .stream().map(user ->
                        UserDto.builder()
                                .id(user.getId())
                                .username(user.getUsername())
                                .surname(user.getSurname())
                                .build()
                ).toList();
    }

    @Override
    public void deleteUser(int userId) {
        userRepo.deleteById(userId);
    }

    @Override
    public UserDto updateUser(int userId, UserAddReq req) {
        var user = userRepo.findById(userId).orElseThrow(() ->
                new RuntimeException("User not found"));

        if (req.surname() != null)
            user.setSurname(req.surname());

        if (req.username() != null)
            user.setUsername(req.username());

        user = userRepo.save(user);

        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .surname(user.getSurname())
                .build();
    }

    @PostConstruct
    public void init() {
        Faker faker = new Faker();

        for (int i = 0; i < 10; i++) {
            addUser(new UserAddReq(faker.name().username(), faker.name().lastName()));
        }
    }
}
