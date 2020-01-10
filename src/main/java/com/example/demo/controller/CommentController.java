package com.example.demo.controller;

import com.example.demo.domain.Comment;
import com.example.demo.domain.Post;
import com.example.demo.service.CommentService;
import com.example.demo.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author Geonguk Han
 * @since 2020-01-10
 */
@Controller
@AllArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;
    private final PostService postService;

    @PostMapping
    @ResponseBody
    public String saveComment(@RequestBody Comment comment) {
        Post byId = postService.findById(comment.getPostId());
        byId.getCommentList().add(comment);

        postService.savePost(byId);
        return "SUCCESS";

    }

    @GetMapping
    public String findCommentList(Model model, Long postId) {
        Post byId = postService.findById(postId);
        model.addAttribute("commentList", byId.getCommentList());
        return "comment";
    }

}
