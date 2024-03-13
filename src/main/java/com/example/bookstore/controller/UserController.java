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

    //닉네임 중복확인
    @GetMapping("/user/check")
    public ResponseEntity<ApiResponse> checkNickname(@RequestParam String nickname) {
        try {
            log.info("닉네임 중복확인 입장!!");
            Boolean checkNickname = userService.checkNickname(nickname);
            if (checkNickname == true) {
                //닉네임 중복이 있어서 만들 수 없을 때 true 리턴
                return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created", "닉네임 중복있음", checkNickname));
            }
            //닉네임 중복이 없어서 만들 수 있을 때 false 리턴
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created", "닉네임 중복없음", checkNickname));
        } catch (Exception e) {
            log.error("e={}", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Created", "닉네임 중복확인 실패", null));
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

    //유저 삭제
    @DeleteMapping("/user/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id) {
        try {
            log.info("유저 삭제하기 입장!!");
            userService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created", "유저 정보 삭제하기 성공", id));
        } catch (Exception e) {
            log.error("e={}", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "유저 정보 삭제하기 실패", null));
        }
    }



}
