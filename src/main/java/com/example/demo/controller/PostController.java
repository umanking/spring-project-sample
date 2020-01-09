package com.example.demo.controller;

import com.example.demo.domain.Post;
import com.example.demo.service.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Geonguk Han
 * @since 2020-01-09
 */
@Controller
@Slf4j
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/post")
    public String postList(Model model) {
        // TODO pageable 기능 추가하기
        model.addAttribute("postList", postService.findPostList());
        return "list";
    }

    @GetMapping("/post/create")
    public String postForm(Model model) {
        model.addAttribute("post", new Post());
        return "create";
    }

    @PostMapping("/post")
    // todo : 왜 model attribute 값으로 넣나?
    public String savePost(@ModelAttribute Post post) {
        log.info("Save Post : {}", post);
        postService.savePost(post);
        return "redirect:/post";
    }

    @GetMapping("/post/{id}")
    public String findPostById(@PathVariable Long id, Model model) {
        model.addAttribute("post", postService.findById(id));
        return "create";
    }

    // GET 수정 화면
    @GetMapping("/post/edit/{id}")
    public String editView(@PathVariable Long id, Model model) {
        model.addAttribute("post", postService.findById(id));
        return "edit";
    }

    @PostMapping("/post/edit/{id}")
    public String updatePost(@ModelAttribute Post post) {
        postService.savePost(post);
        return "redirect:/post";
    }

    @PostMapping("/post/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.delete(id);
        return "redirect:/post";
    }

}
