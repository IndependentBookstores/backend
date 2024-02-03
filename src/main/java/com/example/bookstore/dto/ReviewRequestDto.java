package com.example.bookstore.dto;


import com.example.bookstore.domain.BookStore;
import com.example.bookstore.domain.Review;
import com.example.bookstore.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ReviewRequestDto {

    private String content;

    private Long userId;

    private Long bookStoreId;

    public Review toEntity() {
        User user = User.builder().id(userId).build();
        BookStore bookStore = BookStore.builder().id(bookStoreId).build();

        return Review.builder()
                .content(content)
                .user(user)
                .bookStore(bookStore)
                .build();
    }
}
