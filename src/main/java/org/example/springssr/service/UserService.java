package org.example.springssr.service;

import org.example.springssr.dto.UserDto;
import org.example.springssr.dto.req.UserAddReq;

import java.util.List;

public interface UserService {
    UserDto addUser(UserAddReq req);
    UserDto getUser(int userId);
    List<UserDto> getAllUsers();
    void deleteUser(int userId);
    UserDto updateUser(int userId, UserAddReq req);
}
