package com.example.bookstore.dto;

import com.example.bookstore.domain.BookStore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class BookStoreDetailDto {

    private Long id;

    private String name;

    private String category;

    private String address;

    private String workdayTime;

    private String satTime;

    private String sunTime;

    private String rest;

    private String tel;

    private String optionExplain;

    private String additionalExplain;

    private String instagramId;

    private String instagramLink;

    private List<BlogDto> blogDtos = new ArrayList<>();

    private List<ReviewResponseDto> reviewDtos = new ArrayList<>();

    public BookStoreDetailDto(BookStore bookStore) {
        this.id = bookStore.getId();
        this.name = bookStore.getName();
        this.category = bookStore.getCategory();
        this.address = bookStore.getAddress();
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
