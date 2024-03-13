package com.example.bookstore.dto;

import com.example.bookstore.domain.Heart;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class HeartResponseDto {

    private Long boardId;

    public HeartResponseDto(Heart heart) {
        this.boardId = heart.getBoard().getId();
    }
}
