package com.example.bookstore.dto;

import com.example.bookstore.domain.Board;
import com.example.bookstore.domain.Heart;
import com.example.bookstore.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class HeartRequestDto {

    private Long userId;
    private Long boardId;

    public Heart toEntity() {
        User user = User.builder().id(userId).build();
        Board board = Board.builder().id(boardId).build();
        return Heart.builder()
                .user(user)
                .board(board)
                .build();
    }
}
