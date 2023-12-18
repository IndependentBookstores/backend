package com.example.bookstore.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_id")
    private Long id;

    @Column(name = "blog_title")
    private String title;

    @Column(name = "blog_content")
    private String content;

    @Column(name = "blog_link")
    private String link;

    @Column(name = "author")
    private String author;

    @Column(name = "blog_name")
    private String name;

    @Column(name = "blog_date")
    private String date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_store_id")
    private BookStore bookStore;

}
