package com.example.demo.service;

import com.example.demo.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Geonguk Han
 * @since 2020-01-09
 */
@Component
public class Runner implements ApplicationRunner {

    @Autowired
    private PostService postService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        for (int i = 0; i < 10; i++) {
            Post post = new Post();
            post.setTitle("title " + i);
            post.setContents("contents " + i);
            postService.savePost(post);
        }



    }
}
