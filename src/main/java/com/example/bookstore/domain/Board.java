package com.example.bookstore.domain;

import com.example.bookstore.dto.BoardRequestDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @Column(name = "board_title")
    private String title;

    @Column(name = "board_content")
    private String content;

    @Column(name = "board_image")
    private String image;

    private int likeCount;

    private int replyCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reply> replies = new ArrayList<>();

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<Heart> hearts = new ArrayList<>();

    public Board(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }

    @Builder
    public Board(Long id, String title, String content, String image, int likeCount, int replyCount, User user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.image = image;
        this.likeCount = likeCount;
        this.replyCount = replyCount;
        this.user = user;
    }

    //글 수정
    public void updateBoard(BoardRequestDto boardRequestDto) {
        this.title = boardRequestDto.getTitle();
        this.content = boardRequestDto.getContent();
        this.image = boardRequestDto.getImage();
    }

    //유저 삭제 시 글 유저 정보 변경
    public void deleteUser() {
        this.user = null;
    }
}
