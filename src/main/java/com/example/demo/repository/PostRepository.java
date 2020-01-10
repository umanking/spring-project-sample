package com.example.demo.repository;

import com.example.demo.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Geonguk Han
 * @since 2020-01-09
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Page<Post> findPostByContentsContaining(String keyword, Pageable pageable);
}
