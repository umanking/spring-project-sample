package io.github.umanking.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author Geonguk Han
 * @since 2020-01-09
 */
@Entity
@Data
public class Post extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String writer;

    private String title;

    private String contents;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Comment> commentList;

}
