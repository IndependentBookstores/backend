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
            this.userId = null;
            this.nickname = "익명";
            this.profile_image = null;
        }
    }
}
