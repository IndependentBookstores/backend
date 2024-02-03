package com.example.bookstore.controller;

import com.example.bookstore.dto.BlogDto;
import com.example.bookstore.dto.BoardResponseDto;
import com.example.bookstore.payload.ApiResponse;
import com.example.bookstore.service.BlogService;
import com.example.bookstore.service.BookStoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BlogController {

    private final BlogService blogService;

    //서점 상세정보에 있는 블로그 조회
    @GetMapping("/blog")
    public ResponseEntity<ApiResponse> getBlogs(@RequestParam Long bookStoreId) {
        log.info("서점 상세정보에 있는 블로그 조회 입장!!");
        try {
            List<BlogDto> blogs = blogService.getBlogs(bookStoreId);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created", "서점 상세정보에 있는 블로그 조회 성공", blogs));
        } catch (Exception e) {
            log.error("e={}", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "서점 상세정보에 있는 블로그 조회 실패", null));
        }
    }

}
