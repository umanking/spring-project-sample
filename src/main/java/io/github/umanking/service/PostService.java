package io.github.umanking.service;

import io.github.umanking.domain.Post;
import io.github.umanking.repository.PostRepository;
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
    public Post savePost(final Post post) {
        return postRepository.save(post);
    }

    public Page<Post> findPostList(final Pageable pageable) {
        return postRepository.findAll(pageable);

    }

    public Post findById(final Long id) {
        return postRepository.findById(id).orElseThrow(() -> new RuntimeException("Not exist post"));
    }

    @Transactional
    public void delete(final Long id) {
        postRepository.deleteById(id);
    }


    public Page<Post> findPostByKeyword(final String keyword, final Pageable pageable) {
        return postRepository.findPostByContentsContaining(keyword, pageable);
    }
}
