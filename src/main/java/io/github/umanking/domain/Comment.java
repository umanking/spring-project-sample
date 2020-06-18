package io.github.umanking.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * @author Geonguk Han
 * @since 2020-01-10
 */
@Entity
@Data
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String writer;

    private String contents;

    @Transient
    private Long postId;


}
