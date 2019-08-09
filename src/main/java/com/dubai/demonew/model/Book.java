package com.dubai.demonew.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;

    @Column(nullable = false)
    private String titleNullable;

    @NotNull
    private String titleNotNull;

    @Version
    private int version;

}
