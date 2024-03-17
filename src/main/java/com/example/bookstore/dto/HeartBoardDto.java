package com.example.bookstore.dto;

import com.example.bookstore.domain.Board;
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

    private String image;

    private int likeCount;

    private String createdDate;

    private String modifiedDate;

    private int replyCount;

    private Long userId;

    private String nickname;

    public HeartBoardDto(Heart heart) {
        this.id = heart.getBoard().getId();
        this.title = heart.getBoard().getTitle();
        this.content = heart.getBoard().getContent();
        this.image = heart.getBoard().getImage();
        this.likeCount = heart.getBoard().getLikeCount();
        this.createdDate = heart.getBoard().getCreatedDate();
        this.modifiedDate = heart.getBoard().getModifiedDate();
        this.replyCount = heart.getBoard().getReplyCount();
        if (heart.getBoard().getUser() != null) {
            this.userId = heart.getBoard().getUser().getId();
            this.nickname = heart.getBoard().getUser().getNickname();
        } else {
            this.userId = 0L;
            this.nickname = "익명";
        }
    }
}
