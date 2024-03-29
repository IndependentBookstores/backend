package com.example.bookstore.domain;

import com.example.bookstore.dto.ReplyRequestDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reply extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id")
    private Long id;

    @Column(name = "reply_content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;



    @Builder
    public Reply(String content, Board board, User user) {
        this.content = content;
        this.board = board;
        this.user = user;
    }

    //댓글 수정
    public void updateReply(ReplyRequestDto replyRequestDto) {
        this.content = replyRequestDto.getContent();
    }

    //유저 삭제 시 댓글 유저 정보 변경
    public void deleteUser() {
        this.user = null;
    }
}
