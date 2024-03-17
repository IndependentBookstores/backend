package com.example.bookstore.dto;

import com.example.bookstore.domain.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BookMarkRequestDto {

    private Long userId;
    private Long bookStoreId;

    public BookMark toEntity() {
        User user = User.builder().id(userId).build();
        BookStore bookStore = BookStore.builder().id(bookStoreId).build();
        return BookMark.builder()
                .user(user)
                .bookStore(bookStore)
                .build();
    }
}
