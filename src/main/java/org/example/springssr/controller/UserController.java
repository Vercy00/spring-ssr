package org.example.springssr.controller;

import org.example.springssr.dto.UserDto;
import org.example.springssr.dto.req.UserAddReq;
import org.example.springssr.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public record UserController(
        UserService userService
) {
    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody UserAddReq req) {
        var user = userService.addUser(req);
        return ResponseEntity.created(URI.create("/api/users/%d".formatted(user.id()))).body(user);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(
            @PathVariable int userId,
            @RequestBody UserAddReq req
    ) {
        return ResponseEntity.ok(userService.updateUser(userId, req));
    }
}
