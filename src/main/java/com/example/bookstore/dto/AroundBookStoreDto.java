package com.example.bookstore.dto;

import com.example.bookstore.domain.Blog;
import com.example.bookstore.domain.BookStore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class AroundBookStoreDto {

    private Long id;
    private String name;
    private String image;

    private String category;

    public AroundBookStoreDto(BookStore bookStore) {
        this.id = bookStore.getId();
        this.name = bookStore.getName();
        this.image = bookStore.getImage();
        this.category = bookStore.getCategory();
    }
}
