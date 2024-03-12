package com.example.bookstore.controller;

import com.example.bookstore.domain.Board;
import com.example.bookstore.dto.*;
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
    @PostMapping("/board")
    public ResponseEntity<ApiResponse> save(@RequestBody BoardRequestDto boardRequestDto) {
        log.info("글 생성 입장!!");
        try {
            Long save = boardService.save(boardRequestDto);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created", "글 생성 성공", save));
        } catch (Exception e) {
            log.error("e={}", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "글 생성 실패", null));
        }
    }

    //글 수정
    @PutMapping("/board/{id}/update")
    public ResponseEntity<ApiResponse> save(@PathVariable("id") Long boardId, @RequestBody BoardRequestDto boardRequestDto) {
        log.info("글 생성 입장!!");
        try {
            Long update = boardService.update(boardId, boardRequestDto);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created", "글 수정 성공", update));
        } catch (Exception e) {
            log.error("e={}", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "글 수정 실패", null));
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

    //인기 글 조회(일주일 이내 작성 글, 3개)
    @GetMapping("/board/best")
    public ResponseEntity<ApiResponse> bestBoards() {
        log.info("인기 글 조회 입장!!");
        try {
            List<BestBoardDto> bestBoards = boardService.bestBoards();
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created", "인기 글 조회 성공", bestBoards));
        } catch (Exception e) {
            log.error("e={}", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "인기 글 조회 실패", null));
        }
    }

    //좋아요 누른 글 조회
    @GetMapping("/board/heart")
    public ResponseEntity<ApiResponse> heartBoards(@RequestParam("id") Long userId) {
        log.info("좋아요 누른 글 조회 입장!!");
        try {
            List<HeartBoardDto> heartBoards = boardService.heartBoards(userId);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created", "좋아요 누른 글 조회 성공", heartBoards));
        } catch (Exception e) {
            log.error("e={}", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "좋아요 누른 글 조회 실패", null));
        }
    }



}
