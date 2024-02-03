package com.example.bookstore.dto;

import com.example.bookstore.domain.Blog;
import com.example.bookstore.domain.BookStore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class AroundBookStoreDto {

    private Long bookStoreId;
    private String name;
    private String image;

    public AroundBookStoreDto(BookStore bookStore) {
        this.bookStoreId = bookStore.getId();
        this.name = bookStore.getName();
        this.image = bookStore.getImage();
    }
}
