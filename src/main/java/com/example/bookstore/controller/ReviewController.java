package com.example.bookstore.controller;

import com.example.bookstore.domain.Review;
import com.example.bookstore.payload.ApiResponse;
import com.example.bookstore.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@Slf4j
public class ReviewController {

    private final ReviewService reviewService;

    //리뷰 생성
    @PostMapping("/review")
    public ResponseEntity<ApiResponse> save(@RequestBody Review review)  {
        Long save = reviewService.save(review);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created", "리뷰 생성 성공!", save));
    }
}
