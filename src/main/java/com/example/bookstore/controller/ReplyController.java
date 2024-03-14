package com.example.bookstore.controller;

import com.example.bookstore.dto.ReplyRequestDto;
import com.example.bookstore.dto.ReplyResponseDto;
import com.example.bookstore.payload.ApiResponse;
import com.example.bookstore.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ReplyController {

    private final ReplyService replyService;

    //댓글 생성
    @PostMapping("/reply")
    public ResponseEntity<ApiResponse> save(@RequestBody ReplyRequestDto replyRequestDto) {
        try {
            log.info("댓글 생성 입장!!");
            Long save = replyService.save(replyRequestDto);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created", "댓글 생성 성공", save));

        } catch (Exception e) {
            log.error("e={}", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "댓글 생성 실패", null));

        }
    }

    //댓글 수정
    @PutMapping("/reply/{id}/update")
    public ResponseEntity<ApiResponse> update(@PathVariable("id") Long replyId, @RequestBody ReplyRequestDto replyRequestDto) {
        try {
            log.info("댓글 수정 입장!!");
            Long save = replyService.update(replyId, replyRequestDto);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created", "댓글 수정 성공", save));

        } catch (Exception e) {
            log.error("e={}", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "댓글 수정 실패", null));

        }
    }

    //댓글 삭제
    @DeleteMapping("/reply/{id}/delete")
    public ResponseEntity<ApiResponse> save(@PathVariable("id") Long replyId) {
        try {
            log.info("댓글 삭제 입장!!");
            replyService.delete(replyId);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created", "댓글 삭제 성공", true));
        } catch (Exception e) {
            log.error("e={}", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "댓글 삭제 실패", false));

        }
    }

    //글에 해당하는 댓글 조회
    @GetMapping("/reply")
    public ResponseEntity<ApiResponse> findAllByBoardId(@RequestParam Long boardId) {
        try {
            log.info("글에 해당하는 댓글 조회 입장!!");
            List<ReplyResponseDto> replies = replyService.findByBoardId(boardId);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created", "글에 해당하는 댓글 조회 성공", replies));
        } catch (Exception e) {
            log.error("e={}", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "글에 해당하는 댓글 조회 실패", null));
        }
    }
}
