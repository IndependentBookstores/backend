package com.example.bookstore.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    @Column(name = "review_content")
    private String content;

    private String image;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_store_id")
    private BookStore bookStore;

    @Builder
    public Review(String content, String image, User user, BookStore bookStore) {
        this.content = content;
        this.image = image;
        this.user = user;
        this.bookStore = bookStore;
    }

    //유저 삭제 시 리뷰 유저 정보 변경
    public void deleteUser() {
        this.user = null;
    }
}
