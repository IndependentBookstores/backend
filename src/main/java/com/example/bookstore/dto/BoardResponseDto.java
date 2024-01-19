package com.example.bookstore.dto;

import com.example.bookstore.domain.Board;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class BoardResponseDto {

    //글 정보

    private Long id;

    private String title;

    private String content;

    private String image;

    private int likeCount;

    private int replyCount;

    private Long userId;

    //유저 정보
    private String nickname;

    public BoardResponseDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.image = board.getImage();
        this.likeCount = board.getLikeCount();
        this.replyCount = board.getReplyCount();
        this.userId = board.getUser().getId();
        this.nickname = board.getUser().getNickname();
    }

}
