package com.example.bookstore.dto;

import com.example.bookstore.domain.BookStore;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BookStoreDto {

    private Long id;

    private String name;

    private String category;

    private String address;

    private String latitude;

    private String longitude;

    private String workdayTime;

    private String satTime;

    private String sunTime;

    private String rest;

    private String tel;

    private String optionExplain;

    private String additionalExplain;

    private String instagramId;

    private String instagramLink;

    public BookStoreDto(BookStore bookStore) {
        this.id = bookStore.getId();
        this.name = bookStore.getName();
        this.category = bookStore.getCategory();
        this.address = bookStore.getAddress();
        this.latitude = bookStore.getLatitude();
        this.longitude = bookStore.getLongitude();
        this.workdayTime = bookStore.getWorkdayTime();
        this.satTime = bookStore.getSatTime();
        this.sunTime = bookStore.getSunTime();
        this.rest = bookStore.getRest();
        this.tel = bookStore.getTel();
        this.optionExplain = bookStore.getOptionExplain();
        this.additionalExplain = bookStore.getAdditionalExplain();
        this.instagramId = bookStore.getInstagramId();
        this.instagramLink = bookStore.getInstagramLink();
    }
}
