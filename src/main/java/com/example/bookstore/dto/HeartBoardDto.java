package com.example.bookstore.dto;

import com.example.bookstore.domain.Heart;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HeartBoardDto {

    private Long id;
    private String title;
    private String content;

    public HeartBoardDto(Heart heart) {
        this.id = heart.getBoard().getId();
        this.title = heart.getBoard().getTitle();
        this.content = heart.getBoard().getContent();
    }
}
