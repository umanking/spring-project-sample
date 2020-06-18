package io.github.umanking.service;

import io.github.umanking.domain.Comment;
import io.github.umanking.repository.CommentRepository;
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
    public Comment saveComment(final Comment comment) {
        return commentRepository.save(comment);
    }
}
