package com.example.demo.service;

import com.example.demo.domain.Comment;
import com.example.demo.repository.CommentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Geonguk Han
 * @since 2020-01-10
 */
@Service
@Slf4j
@AllArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }
}
