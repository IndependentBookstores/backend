package com.example.bookstore.dto;

import com.example.bookstore.domain.Board;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class BoardDetailDto {

    //글 정보
    private Long id;

    private String title;

    private String content;

    private String image;

    private int likeCount;

    private String createdDate;

    private String modifiedDate;

    private int replyCount;

    private Long userId;

    private Boolean isLike;

    //유저 정보
    private String nickname;

    public BoardDetailDto(Board board, Boolean isLike) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.image = board.getImage();
        this.likeCount = board.getLikeCount();
        this.createdDate = board.getCreatedDate();
        this.modifiedDate = board.getModifiedDate();
        this.replyCount = board.getReplyCount();
        this.userId = board.getUser().getId();
        this.isLike = isLike;
        this.nickname = board.getUser().getNickname();
    }
}
