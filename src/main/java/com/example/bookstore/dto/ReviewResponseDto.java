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

    private String profile_image;

    private String createdDate;

    private String modifiedDate;

    private String nickname;

    public ReviewResponseDto(Review review) {
        this.id = review.getId();
        this.content = review.getContent();
        this.profile_image = review.getUser().getProfileImage();
        this.createdDate = review.getCreatedDate();
        this.modifiedDate = review.getModifiedDate();
        this.nickname = review.getUser().getNickname();
    }
}
