package com.example.bookstore.controller;

import com.example.bookstore.domain.Board;
import com.example.bookstore.dto.BoardRequestDto;
import com.example.bookstore.dto.BoardResponseDto;
import com.example.bookstore.dto.BookStoreDetailDto;
import com.example.bookstore.payload.ApiResponse;
import com.example.bookstore.service.AmazonS3Service;
import com.example.bookstore.service.BoardService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.MultipartConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;

    //글 생성
    @PostMapping(value = "/board", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<ApiResponse> save(@RequestPart BoardRequestDto boardRequestDto, @RequestPart MultipartFile image) {
        log.info("글 생성 입장!!");
        try {
            Long save = boardService.save(boardRequestDto, image);
            ObjectMapper mapper = new ObjectMapper();
            log.info("bookstore={}", mapper.writeValueAsString(save));
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created", "글 생성 성공", save));
        } catch (Exception e) {
            log.error("e={}", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "글 생성 실패", null));
        }
    }

    //글 전체 조회
    @GetMapping("/board/all")
    public ResponseEntity<ApiResponse> findAll() {
        log.info("글 전체 조회 입장!!");
        try {
            List<BoardResponseDto> boards = boardService.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created", "글 전체 조회 성공", boards));
        } catch (Exception e) {
            log.error("e={}", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "글 전체 조회 실패", null));
        }
    }

    //선택한 글 조회
    @GetMapping("/board/{id}")
    public ResponseEntity<ApiResponse> findById(@PathVariable Long id) {
        log.info("선택한 글 조회 입장!!");
        try {
            BoardResponseDto board = boardService.findById(id);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created", "선택한 글 조회 성공", board));
        } catch (Exception e) {
            log.error("e={}", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "선택한 글 조회 실패", null));
        }
    }


}
