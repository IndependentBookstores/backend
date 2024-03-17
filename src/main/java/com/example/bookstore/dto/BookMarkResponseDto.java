package com.example.bookstore.dto;

import com.example.bookstore.domain.BookMark;
import com.example.bookstore.domain.BookStore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BookMarkResponseDto {

    private Long id;
    private String name;
    private String category;
    private String address;
    private String image;

    public BookMarkResponseDto(BookMark bookMark) {
        this.id = bookMark.getBookStore().getId();
        this.name = bookMark.getBookStore().getName();
        this.category = bookMark.getBookStore().getCategory();
        this.address = bookMark.getBookStore().getAddress();
        this.image = bookMark.getBookStore().getImage();
    }
}
