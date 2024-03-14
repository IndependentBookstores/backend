package com.example.bookstore.dto;

import com.example.bookstore.domain.BaseTimeEntity;
import com.example.bookstore.domain.Review;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ReviewResponseDto {

    private Long id;
    private String content;

    private String image;
    private String createdDate;

    private String modifiedDate;

    private Long userId;

    private String nickname;

    private String profile_image;


    public ReviewResponseDto(Review review) {
        this.id = review.getId();
        this.content = review.getContent();
        this.image = review.getImage();
        this.createdDate = review.getCreatedDate();
        this.modifiedDate = review.getModifiedDate();
        if (review.getUser() != null) {
            this.userId = review.getUser().getId();
            this.nickname = review.getUser().getNickname();
            this.profile_image = review.getUser().getProfileImage();
        } else {
            this.userId = 0L;
            this.nickname = "익명";
            this.profile_image = "https://s3-book.s3.ap-northeast-2.amazonaws.com/%EC%9C%A0%EC%A0%80+%EA%B8%B0%EB%B3%B8.png";
        }
    }
}
