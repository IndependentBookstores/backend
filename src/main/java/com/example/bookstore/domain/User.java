package com.example.bookstore.domain;

import com.example.bookstore.dto.UserDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @Column(name = "user_id")
    private Long id;

    private String nickname;

    private int age;

    private String category;

    private String profileImage;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Board> boards = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Reply> replies = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Heart> hearts = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    @Builder
    public User(Long id, String nickname, int age, String category, String profileImage) {
        this.id = id;
        this.nickname = nickname;
        this.age = age;
        this.category = category;
        this.profileImage = profileImage;
    }

    //유저 수정
    public void updateUser(UserDto userDto) {
        this.nickname = userDto.getNickname();
        this.age = userDto.getAge();
        this.category = userDto.getCategory();
        this.profileImage = userDto.getProfileImage();
    }
}
