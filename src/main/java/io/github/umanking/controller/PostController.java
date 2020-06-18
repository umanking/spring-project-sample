package io.github.umanking.controller;

import io.github.umanking.domain.Post;
import io.github.umanking.service.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

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
    public String postList(final Model model, final Pageable pageable) {
        final Page<Post> postList = postService.findPostList(PageRequest.of(pageable.getPageNumber(), 10));

        model.addAttribute("postList", postList);
        return "list";
    }

    // todo: 위에 거랑 합치기
    @GetMapping("/post/search")
    public String searchPost(final Model model, @RequestParam final String keyword, final Pageable pageable) {
        final Page<Post> postList = postService.findPostByKeyword(keyword, pageable);
        model.addAttribute("postList", postList);
        return "list";
    }


    @GetMapping("/post/create")
    public String postForm(final Model model) {
        model.addAttribute("post", new Post());
        return "create";
    }

    @PostMapping("/post")
    // todo : 왜 model attribute 값으로 넣나?
    public String savePost(@ModelAttribute final Post post) {
        log.info("Save Post : {}", post);
        postService.savePost(post);
        return "redirect:/post";
    }

    @GetMapping("/post/{id}")
    public String findPostById(@PathVariable final Long id, final Model model) {
        final Post byId = postService.findById(id);
        model.addAttribute("post", byId);
        model.addAttribute("commentList", byId.getCommentList() != null ? byId.getCommentList() : Collections.emptyList());
        return "view";
    }

    // GET 수정 화면
    @GetMapping("/post/edit/{id}")
    public String editView(@PathVariable final Long id, final Model model) {
        model.addAttribute("post", postService.findById(id));
        return "edit";
    }

    @PostMapping("/post/edit/{id}")
    public String updatePost(@ModelAttribute final Post post) {
        final Post byId = postService.findById(post.getId());
        byId.setTitle(post.getTitle());
        byId.setContents(post.getContents());

        postService.savePost(byId);
        return "redirect:/post";
    }

    @PostMapping("/post/delete/{id}")
    public String deletePost(@PathVariable final Long id) {
        postService.delete(id);
        return "redirect:/post";
    }

}
