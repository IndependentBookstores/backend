package com.example.bookstore.dto;

import com.example.bookstore.domain.BookStore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class BookStoreResponseDto {

    private Long id;
    private String name;
    private String category;
    private String address;
    private String image;

    public BookStoreResponseDto(BookStore bookStore) {
        this.id = bookStore.getId();
        this.name = bookStore.getName();
        this.category = bookStore.getCategory();
        this.address = bookStore.getAddress();
        this.image = bookStore.getImage();
    }
}
