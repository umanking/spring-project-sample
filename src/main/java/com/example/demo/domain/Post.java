package com.example.demo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Geonguk Han
 * @since 2020-01-09
 */
@Entity
@Data
public class Post {

    @Id @GeneratedValue
    private Long id;

    private String title;

    private String contents;

}
