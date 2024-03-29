package com.example.bookstore.dto;

import com.example.bookstore.domain.BaseTimeEntity;
import com.example.bookstore.domain.Board;
import com.example.bookstore.domain.Reply;
import com.example.bookstore.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ReplyResponseDto {

    private Long id;

    private String content;

    private String createdDate;

    private String modifiedDate;

    private Long boardId;

    private Long userId;

    private String profile_image;

    private String nickname;

    public ReplyResponseDto(Reply reply) {
        this.id = reply.getId();
        this.content = reply.getContent();
        this.createdDate = reply.getCreatedDate();
        this.modifiedDate = reply.getModifiedDate();
        this.boardId = reply.getBoard().getId();
        if (reply.getUser() != null) {
            this.userId = reply.getUser().getId();
            this.nickname = reply.getUser().getNickname();
            this.profile_image = reply.getUser().getProfileImage();
        } else {
            this.userId = 0L;
            this.nickname = "익명";
            this.profile_image = "https://s3-book.s3.ap-northeast-2.amazonaws.com/%EC%9C%A0%EC%A0%80+%EA%B8%B0%EB%B3%B8.png";
        }
    }
}
