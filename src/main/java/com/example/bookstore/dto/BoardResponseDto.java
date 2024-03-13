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

    private String createdDate;

    private String modifiedDate;

    private int replyCount;

    private Long userId;

    private Boolean isLike;
    
    //유저 정보
    private String nickname;

    private String profile_image;

    public BoardResponseDto(Board board, Boolean isLike) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.image = board.getImage();
        this.likeCount = board.getLikeCount();
        this.createdDate = board.getCreatedDate();
        this.modifiedDate = board.getModifiedDate();
        this.replyCount = board.getReplyCount();
        this.isLike = isLike;
        if (board.getUser() != null) {
            this.userId = board.getUser().getId();
            this.nickname = board.getUser().getNickname();
            this.profile_image = board.getUser().getProfileImage();
        } else {
            this.userId = null;
            this.nickname = "익명";
            this.profile_image = null;
        }

    }
    public BoardResponseDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.image = board.getImage();
        this.likeCount = board.getLikeCount();
        this.createdDate = board.getCreatedDate();
        this.modifiedDate = board.getModifiedDate();
        this.replyCount = board.getReplyCount();
        if (board.getUser() != null) {
            this.userId = board.getUser().getId();
            this.nickname = board.getUser().getNickname();
        } else {
            this.userId = null;
            this.nickname = "익명";
        }

    }

    public void setIsLike(Boolean isLike) {
        this.isLike = isLike;
    }

}
