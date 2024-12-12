package org.example.springssr.controller;

import org.example.springssr.service.PostService;
import org.example.springssr.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public record TemplateController(
        UserService userService,
        PostService postService
) {
    @GetMapping("/ssr")
    public String showUserList(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "/ssr/index";
    }

    @GetMapping("/ssr/users/{userId}/edit")
    public String editUser(
            @PathVariable int userId,
            Model model
    ) {
        model.addAttribute("user", userService.getUser(userId));
        return "/ssr/user-edit";
    }

    @GetMapping("/ssr/users")
    public String addUser(Model model) {
        return "/ssr/user-add";
    }

    @GetMapping("/ssr/posts")
    public String showPostList(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        return "/ssr/posts";
    }

    @GetMapping("/csr")
    public String noSSR(Model model) {
        return "/csr/index";
    }

    @GetMapping("/csr/posts")
    public String noSSRPosts(Model model) {
        return "/csr/posts";
    }
}
