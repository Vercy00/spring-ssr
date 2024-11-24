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

    @GetMapping("/csr")
    public String noSSR(Model model) {
        return "/csr/index";
    }

    @GetMapping("/csr/posts")
    public String noSSRPosts(Model model) {
        return "/csr/posts";
    }
}
