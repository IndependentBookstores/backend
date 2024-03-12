package com.example.bookstore.controller;

import com.example.bookstore.payload.ApiResponse;
import com.example.bookstore.service.AmazonS3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ImageController {

    private final AmazonS3Service amazonS3Service;

    @PostMapping( "/image")
    public ResponseEntity<ApiResponse> save(@RequestPart MultipartFile image) {
        try {
            log.info("이미지 생성 입장!!");
            String imageUrl = amazonS3Service.upload(image);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created", "이미지 생성 성공", imageUrl));
        } catch (Exception e) {
            log.error("e={}", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "이미지 생성 실패", null));
        }
    }
}
