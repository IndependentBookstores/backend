package com.example.bookstore.dto;

import com.example.bookstore.domain.BookStore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MapBookStoreDto {

    private Long id;
    private String name;
    private String category;

    private String latitude;

    private String longitude;

    public MapBookStoreDto(BookStore bookStore) {
        this.id = bookStore.getId();
        this.name = bookStore.getName();
        this.category = bookStore.getCategory();
        this.latitude = bookStore.getLatitude();
        this.longitude = bookStore.getLongitude();
    }
}
