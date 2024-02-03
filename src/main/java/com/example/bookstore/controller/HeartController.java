package com.example.bookstore.controller;

import com.example.bookstore.dto.BoardRequestDto;
import com.example.bookstore.dto.HeartRequestDto;
import com.example.bookstore.payload.ApiResponse;
import com.example.bookstore.service.HeartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@Slf4j
public class HeartController {

    private final HeartService heartService;

    //좋아요
    @PostMapping("/heart")
    public ResponseEntity<ApiResponse> save(@RequestBody HeartRequestDto heartRequestDto) {
        log.info("좋아요 입장!!");
        try {
            Boolean save = heartService.save(heartRequestDto);
            if (save == false) {
                heartService.delete(heartRequestDto);
                return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created", "좋아요 감소", save));
            }
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created", "좋아요 증가", save));
        } catch (Exception e) {
            log.error("e={}", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "좋아요 실패", null));
        }
    }
}
