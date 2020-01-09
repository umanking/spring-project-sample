package com.example.demo.controller;

import com.example.demo.domain.Post;
import com.example.demo.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author Geonguk Han
 * @since 2020-01-09
 */
@Controller
@RequestMapping(value = "/post")
@AllArgsConstructor
public class PostController {

    private final PostService postService;



    // 리스트 화면
    @GetMapping
    public String postList(Model model, Pageable pageable) {
        model.addAttribute("postList", postService.findPostList(pageable));
        return "post_list";
    }

    @GetMapping("/create")
    public String postForm(@PathVariable Long id, Model model) {
        model.addAttribute("post", postService.findById(id));
        return "post_form";
    }

    @PostMapping
    public String savePost(@RequestBody Post post) {
        postService.savePost(post);
        return "redirect:/post";
    }

    @GetMapping("/{id}")
    public String findPostById(@PathVariable Long id, Model model) {
        model.addAttribute("post", postService.findById(id));
        return "post_form";
    }

    @PutMapping("/{id}")
    public String modifyPostById(@PathVariable Long id, Model model) {
        model.addAttribute("post", postService.findById(id));
        return "post_list";
    }




}
