package com.example.bookstore.controller;

import com.example.bookstore.dto.BoardRequestDto;
import com.example.bookstore.dto.BookMarkRequestDto;
import com.example.bookstore.dto.BookMarkResponseDto;
import com.example.bookstore.payload.ApiResponse;
import com.example.bookstore.service.BookMarkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BookMarkController {

    private final BookMarkService bookMarkService;

    //북마크 저장
    @PostMapping("/bookmark")
    public ResponseEntity<ApiResponse> save(@RequestBody BookMarkRequestDto bookMarkRequestDto) {
        log.info("북마크 저장 입장!!");
        try {
            Boolean save = bookMarkService.save(bookMarkRequestDto);
            if (save == false) {
                bookMarkService.delete(bookMarkRequestDto);
                return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created", "북마크 취소", save));
            }
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created", "북마크 저장", save));
        } catch (Exception e) {
            log.error("e={}", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "좋아요 실패", null));
        }
    }

    //북마크 한 서점 리스트 조회
    @GetMapping("/bookmark/{id}")
    public ResponseEntity<ApiResponse> save(@PathVariable("id") Long userId) {
        log.info("북마크 한 서점 리스트 조회 입장!!");
        try {
            List<BookMarkResponseDto> bookMarks = bookMarkService.findAll(userId);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created", "북마크 한 서점 리스트 조회 성공", bookMarks));
        } catch (Exception e) {
            log.error("e={}", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "북마크 한 서점 리스트 조회 실패", null));
        }
    }
}
