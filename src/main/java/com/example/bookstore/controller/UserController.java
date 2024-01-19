package com.example.bookstore.controller;

import com.example.bookstore.domain.User;
import com.example.bookstore.dto.UserDto;
import com.example.bookstore.payload.ApiResponse;
import com.example.bookstore.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public class UserController {

    private final UserService userService;

    //유저 생성
    @PostMapping("/user")
    public ResponseEntity<ApiResponse> save(@RequestBody UserDto userDto) {
        try {
            log.info("유저 생성 입장!!");
            Long save = userService.save(userDto);
            ObjectMapper mapper = new ObjectMapper();
            log.info("bookstore={}", mapper.writeValueAsString(save));
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created", "유저 생성 성공", save));
        } catch (Exception e) {
            log.error("e={}", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "유저 생성 실패", null));
        }
    }
}
