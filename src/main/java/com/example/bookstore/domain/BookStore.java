package com.example.bookstore.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_store_id")
    private Long id;

    @Column(name = "book_store_name")
    private String name;

    private String category;

    private String address;

    private String latitude;

    private String longitude;

    private String workdayTime;

    private String satTime;

    private String sunTime;

    private String rest;

    private String tel;

    private String optionExplain;

    private String additionalExplain;

    private String instagramId;

    private String instagramLink;

    @OneToMany(mappedBy = "bookStore")
    private List<Blog> blogs = new ArrayList<>();

    @OneToMany(mappedBy = "bookStore")
    private List<Review> reviews = new ArrayList<>();


}
