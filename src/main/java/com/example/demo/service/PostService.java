package com.example.demo.service;

import com.example.demo.domain.Post;
import com.example.demo.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Geonguk Han
 * @since 2020-01-09
 */
@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    public Page<Post> findPostList(Pageable pageable) {
        return postRepository.findAll(pageable);

    }

    public Post findById(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new RuntimeException("Not exist post"));
    }

    @Transactional
    public void delete(Long id) {
        postRepository.deleteById(id);
    }


    public Page<Post> findPostByKeyword(String keyword, Pageable pageable) {
        return postRepository.findPostByContentsContaining(keyword, pageable);
    }
}
