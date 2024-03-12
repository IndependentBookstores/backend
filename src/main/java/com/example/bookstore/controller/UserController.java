package com.example.bookstore.controller;

import com.example.bookstore.domain.User;
import com.example.bookstore.dto.UserDto;
import com.example.bookstore.payload.ApiResponse;
import com.example.bookstore.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    //유저 생성
    @PostMapping( "/user")
    public ResponseEntity<ApiResponse> save(@RequestBody UserDto userDto) {
        try {
            log.info("유저 생성 입장!!");
            Long save = userService.save(userDto);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created", "유저 생성 성공", save));
        } catch (Exception e) {
            log.error("e={}", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "유저 생성 실패", null));
        }
    }

    //유저 수정
    @PutMapping("/user/{id}/update")
    public ResponseEntity<ApiResponse> update(@PathVariable("id") Long userId, @RequestBody UserDto userDto) {
        try {
            log.info("유저 업데이트 입장!!");
            Long update = userService.update(userId, userDto);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created", "유저 수정 성공", update));
        } catch (Exception e) {
            log.error("e={}", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "유저 수정 실패", null));
        }
    }

    //유저 정보 불러오기
    @GetMapping("/user/{id}")
    public ResponseEntity<ApiResponse> save(@PathVariable Long id) {
        try {
            log.info("유저 정보 불러오기 입장!!");
            UserDto user = userService.findUser(id);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created", "유저 정보 불러오기 성공", user));
        } catch (Exception e) {
            log.error("e={}", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "유저 정보 불러오기 실패", null));
        }
    }



}
