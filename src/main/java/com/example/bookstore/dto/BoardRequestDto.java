package com.example.bookstore.dto;

import com.example.bookstore.domain.Board;
import com.example.bookstore.domain.Heart;
import com.example.bookstore.domain.Reply;
import com.example.bookstore.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class BoardRequestDto {

    private String title;

    private String content;

    private String image;

    private int likeCount;

    private int replyCount;

    private Long userId;
    public Board toEntity(String imageUrl) {
        User user = User.builder().id(userId).build();
        return Board.builder()
                .title(title)
                .content(content)
                .image(imageUrl)
                .likeCount(likeCount)
                .replyCount(replyCount)
                .user(user)
                .build();
    }
}
