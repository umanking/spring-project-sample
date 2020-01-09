package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Geonguk Han
 * @since 2020-01-09
 */
@Entity
public class Post {

    @Id @GeneratedValue
    private Long id;

    private String title;

    private String contents;

}
