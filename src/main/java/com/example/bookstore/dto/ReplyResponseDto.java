package com.example.bookstore.dto;

import com.example.bookstore.domain.Board;
import com.example.bookstore.domain.Reply;
import com.example.bookstore.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ReplyResponseDto {

    private Long id;

    private String content;

    private Long boardId;

    private Long userId;

    public ReplyResponseDto(Reply reply) {
        this.id = reply.getId();
        this.content = reply.getContent();
        this.boardId = reply.getBoard().getId();
        this.userId = reply.getUser().getId();
    }
}
