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

    private String content;
    private int likeCount;
    private int replyCount;

    private String nickname;

    public BestBoardDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.likeCount = board.getLikeCount();
        this.replyCount = board.getReplyCount();
        if (board.getUser() != null) {
            this.nickname = board.getUser().getNickname();
        } else {
            this.nickname = "익명";
        }
    }
}
