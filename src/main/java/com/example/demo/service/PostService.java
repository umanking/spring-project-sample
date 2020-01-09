package com.example.demo.service;

import com.example.demo.domain.Post;
import com.example.demo.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Geonguk Han
 * @since 2020-01-09
 */
@Service
@AllArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    public Post findById(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new RuntimeException("Not exist post"));
    }

    public void delete(Long id) {
        postRepository.deleteById(id);
    }

    public Page<Post> findPostList(Pageable pageable) {
        Page<Post> all = postRepository.findAll(pageable);
        return all;

    }

}
