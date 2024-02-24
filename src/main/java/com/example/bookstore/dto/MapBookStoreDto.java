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

    private String image;

    private String address;

    private double latitude;

    private double longitude;

    public MapBookStoreDto(BookStore bookStore) {
        this.id = bookStore.getId();
        this.name = bookStore.getName();
        this.category = bookStore.getCategory();
        this.image = bookStore.getImage();
        this.address = bookStore.getAddress();
        this.latitude = Double.parseDouble(bookStore.getLatitude());
        this.longitude = Double.parseDouble(bookStore.getLongitude());
    }
}
