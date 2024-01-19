package com.example.bookstore.dto;

import com.example.bookstore.domain.Blog;
import com.example.bookstore.domain.BookStore;
import com.example.bookstore.domain.Review;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
public class BookStoreDetailDto {

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

    private List<BlogDto> blogDtos = new ArrayList<>();

    private List<ReviewDto> reviewDtos = new ArrayList<>();

    public BookStoreDetailDto(BookStore bookStore, List<Blog> blogs, List<Review> reviews) {
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

        for (int i = 0; i < blogs.size(); i++) {
            Blog blog = blogs.get(i);
            BlogDto blogDto = new BlogDto();

            blogDto.setTitle(blog.getTitle());
            blogDto.setContent(blog.getContent());
            blogDto.setLink(blog.getLink());
            blogDto.setAuthor(blog.getAuthor());
            blogDto.setName(blog.getName());
            blogDto.setDate(blog.getDate());

            blogDtos.add(blogDto);
        }

        for (int i = 0; i < reviews.size(); i++) {
            Review review = reviews.get(i);
            ReviewDto reviewDto = new ReviewDto();

            reviewDto.setContent(review.getContent());
            reviewDto.setProfile_image(review.getUser().getProfileImage());
            reviewDto.setNickname(review.getUser().getNickname());

            reviewDtos.add(reviewDto);
        }

    }
}
