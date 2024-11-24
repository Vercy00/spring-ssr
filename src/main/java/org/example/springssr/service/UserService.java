package org.example.springssr.service;

import org.example.springssr.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto addUser(String username);
    List<UserDto> getAllUsers();
}
