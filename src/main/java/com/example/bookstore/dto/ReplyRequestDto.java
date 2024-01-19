package com.example.bookstore.dto;

import com.example.bookstore.domain.Board;
import com.example.bookstore.domain.Reply;
import com.example.bookstore.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ReplyRequestDto {

    private String content;

    private Long boardId;

    private Long userId;

    public Reply toEntity() {
        Board board = Board.builder().id(boardId).build();
        User user = User.builder().id(userId).build();

        return Reply.builder()
                .content(content)
                .board(board)
                .user(user)
                .build();
    }
}
