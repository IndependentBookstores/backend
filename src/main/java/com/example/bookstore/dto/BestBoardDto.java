package com.example.bookstore.dto;

import com.example.bookstore.domain.Board;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BestBoardDto {

    private Long id;
    private String title;
    private int likeCount;
    private int replyCount;

    public BestBoardDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.likeCount = board.getLikeCount();
        this.replyCount = board.getReplyCount();
    }
}
