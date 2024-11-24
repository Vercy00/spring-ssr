package org.example.springssr.controller;

import org.example.springssr.service.PostService;
import org.example.springssr.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/ssr/posts")
    public String showPostList(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        return "/ssr/posts";
    }

    @GetMapping("/no-ssr")
    public String noSSR(Model model) {
        return "/no-ssr/index";
    }

    @GetMapping("/no-ssr/posts")
    public String noSSRPosts(Model model) {
        return "/no-ssr/posts";
    }
}
