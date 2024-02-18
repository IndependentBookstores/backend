package com.example.bookstore.controller;

import com.example.bookstore.domain.BookStore;
import com.example.bookstore.dto.AroundBookStoreDto;
import com.example.bookstore.dto.BookStoreDetailDto;
import com.example.bookstore.dto.BookStoreResponseDto;
import com.example.bookstore.dto.MapBookStoreDto;
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

import java.util.List;
import java.util.stream.Collectors;

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
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created", "서점 정보를 가져오는데 성공", bookStore));
        } catch (Exception e) {
            System.out.println("getBookStore 없음!!");
            log.error("e={}", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "서점 정보를 가져오는데 실패", null));
        }
    }

    //지도 마커 서점 리스트
    @GetMapping("/book-store/map")
    public ResponseEntity<ApiResponse> getAroundBookStore(@RequestParam String latitude, @RequestParam String longitude, @RequestParam int distance) {
        log.info("getAroundBookStore 입장!!");
        try {
            List<MapBookStoreDto> mapBookStore = bookStoreService.getMapBookStore(latitude, longitude, distance);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created", distance + "km 거리의 " + "지도 마커 서점 리스트 " + mapBookStore.size() + "개 정보를 가져오는데 성공", mapBookStore));
        } catch (Exception e) {
            log.error("e={}", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "지도 마커 서점 리스트를 가져오는데 실패", null));
        }
    }

    //주변 서점 리스트 보여주기
    @GetMapping("/book-store/around")
    public ResponseEntity<ApiResponse> getAroundBookStore(@RequestParam String latitude, @RequestParam String longitude) {
        log.info("getAroundBookStore 입장!!");
        try {
            List<AroundBookStoreDto> aroundBookStore = bookStoreService.getAroundBookStore(latitude, longitude);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created", "주변 서점 " + aroundBookStore.size() + "개 정보를 가져오는데 성공", aroundBookStore));
        } catch (Exception e) {
            log.error("e={}", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "주변 서점 정보를 가져오는데 실패", null));
        }
    }

    //지역 별 서점 리스트
    @GetMapping("/book-store/region")
    public ResponseEntity<ApiResponse> getRegionBookStore(@RequestParam String region) {
        log.info("getRegionBookStore 입장!!");
        try {
            List<BookStoreResponseDto> regionBookStore = bookStoreService.getRegionBookStore(region);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created", "지역 별 서점 리스트를 가져오는데 성공", regionBookStore));
        } catch (Exception e) {
            log.error("e={}", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "지역 별 서점 리스트를 가져오는데 실패", null));
        }
    }

    //전체 서점 리스트
//    @GetMapping("/book-store/all")
//    public ResponseEntity<ApiResponse> getBookStoreList() {
//        log.info("getBookStoreList 입장!!");
//        try {
//            List<BookStoreResponseDto> bookStoreList = bookStoreService.getBookStoreList();
//            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Created", "전체 서점 리스트를 가져오는데 성공", bookStoreList));
//        } catch (Exception e) {
//            log.error("e={}", e);
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("NotFound", "전체 서점 리스트를 가져오는데 실패", null));
//        }
//    }
}
