package com.example.bookstore.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @Column(name = "book_store_image")
    private String image;

    @OneToMany(mappedBy = "bookStore")
    private List<Blog> blogs = new ArrayList<>();

    @OneToMany(mappedBy = "bookStore")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "bookStore")
    private List<BookMark> bookMarks = new ArrayList<>();

    public BookStore(String name) {
        this.name = name;
    }

    @Builder
    public BookStore(Long id, String name, String category, String address, String latitude, String longitude, String workdayTime, String satTime, String sunTime, String rest, String tel, String optionExplain, String additionalExplain, String instagramId, String instagramLink, String image) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.workdayTime = workdayTime;
        this.satTime = satTime;
        this.sunTime = sunTime;
        this.rest = rest;
        this.tel = tel;
        this.optionExplain = optionExplain;
        this.additionalExplain = additionalExplain;
        this.instagramId = instagramId;
        this.instagramLink = instagramLink;
        this.image = image;
    }
}
