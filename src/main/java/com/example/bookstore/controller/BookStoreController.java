package com.example.bookstore.controller;

import com.example.bookstore.dto.BookStoreDetailDto;
import com.example.bookstore.payload.ApiResponse;
import com.example.bookstore.service.BookStoreService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BookStoreController {

    private final BookStoreService bookStoreService;

    //서점 상세정보
    @GetMapping("/book-store")
    public ResponseEntity<ApiResponse> getBookStore(@RequestParam("bookStoreId") Long bookStoreId) {
        log.info("getBookStore 입장!!");
        try {
            BookStoreDetailDto bookStore = bookStoreService.getBookStore(bookStoreId);
            ObjectMapper mapper = new ObjectMapper();
            log.info("bookstore={}", mapper.writeValueAsString(bookStore));
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created", "서점 정보를 가져오는데 성공", bookStore));
        } catch (Exception e) {
            System.out.println("getBookStore 없음!!");
            log.error("e={}", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "서점 정보를 가져오는데 실패", null));
        }
    }
}
