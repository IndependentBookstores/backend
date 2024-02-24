package com.example.bookstore.service;

import com.example.bookstore.domain.User;
import com.example.bookstore.dto.UserDto;
import com.example.bookstore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final AmazonS3Service amazonS3Service;

    private final String defaultImage = "https://s3-book.s3.ap-northeast-2.amazonaws.com/%EC%9C%A0%EC%A0%80+%EA%B8%B0%EB%B3%B8.png";

    //유저 생성
    @Transactional
    public Long save(UserDto userDto, MultipartFile image) throws IOException {
        String imageUrl = "";
        if (image.isEmpty()) {
            imageUrl = defaultImage;
        } else {
            imageUrl = amazonS3Service.upload(image);
        }
        return userRepository.save(userDto.toEntity(imageUrl)).getId();
    }

    //유저 정보 불러오기
    public UserDto findUser(Long userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다"));
        return new UserDto(user);
    }

}
