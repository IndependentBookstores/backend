package com.example.bookstore.controller;

import com.example.bookstore.dto.ReviewRequestDto;
import com.example.bookstore.dto.ReviewResponseDto;
import com.example.bookstore.payload.ApiResponse;
import com.example.bookstore.service.ReviewService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@Slf4j
public class ReviewController {

    private final ReviewService reviewService;

    //리뷰 생성
    @PostMapping("/review")
    public ResponseEntity<ApiResponse> save(@RequestBody ReviewRequestDto reviewRequestDto)  {
        log.info("리뷰 생성 입장!!");
        try {
            Long save = reviewService.save(reviewRequestDto);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created", "리뷰 생성 성공", save));
        } catch (Exception e) {
            log.error("e={}", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "리뷰 생성 실패", null));
        }
    }

    //서점 상세정보에 있는 리뷰 조회
    @GetMapping("/review")
    public ResponseEntity<ApiResponse> getReviews(@RequestParam Long bookStoreId) {
        log.info("서점 상세정보에 있는 리뷰 조회 입장!!");
        try {
            List<ReviewResponseDto> reviews = reviewService.getReviews(bookStoreId);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created", "서점 상세정보에 있는 리뷰 조회 성공", reviews));
        } catch (Exception e) {
            log.error("e={}", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "서점 상세정보에 있는 리뷰 조회 실패", null));
        }
    }
}
