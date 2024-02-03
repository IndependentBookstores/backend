package com.example.bookstore.dto;

import com.example.bookstore.domain.User;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserDto {

    private Long id;

    private String nickname;

    private int age;

    private String category;

    private String profileImage;

    public User toEntity() {
        return User.builder()
                .id(id)
                .nickname(nickname)
                .age(age)
                .category(category)
                .profileImage(profileImage)
                .build();
    }
    
}
