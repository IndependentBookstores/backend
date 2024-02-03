package com.example.bookstore.service;

import com.example.bookstore.domain.Blog;
import com.example.bookstore.domain.BookStore;
import com.example.bookstore.domain.Review;
import com.example.bookstore.dto.AroundBookStoreDto;
import com.example.bookstore.dto.BookStoreDetailDto;
import com.example.bookstore.dto.BookStoreResponseDto;
import com.example.bookstore.repository.BlogRepository;
import com.example.bookstore.repository.BookStoreRepository;
import com.example.bookstore.repository.ReviewRepository;
import com.example.bookstore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class BookStoreService {

    private final BookStoreRepository bookStoreRepository;
    private final BlogRepository blogRepository;

    private final ReviewRepository reviewRepository;


    //서점 상세정보
    public BookStoreDetailDto getBookStore(Long bookStoreId) {
        BookStore bookStore = bookStoreRepository.findById(bookStoreId).orElseThrow(()->new IllegalArgumentException("해당 서점이 없습니다."));
        return new BookStoreDetailDto(bookStore);
    }

    //주변 서점 3개 보여주기
    public List<AroundBookStoreDto> getAroundBookStore(String latitude, String longitude) {
        BigDecimal decimalLat = new BigDecimal(latitude);
        BigDecimal decimalLong = new BigDecimal(longitude);

        List<BookStore> aroundBookStore = bookStoreRepository.getAroundBookStore(decimalLat, decimalLong);
        return aroundBookStore.stream().map(AroundBookStoreDto::new).collect(Collectors.toList());
    }

    //지역 별 서점 리스트
    public List<BookStoreResponseDto> getRegionBookStore(String regions) {
        List<BookStore> regionBookStore = new ArrayList<>();
        String[] region = regions.split("@");
        for (String s : region) {
            log.info("region={}", s);
            regionBookStore.addAll(bookStoreRepository.getRegionBookStore(s));
        }
        return regionBookStore.stream().map(BookStoreResponseDto::new).collect(Collectors.toList());
    }

    //전체 서점 리스트
//    public List<BookStoreResponseDto> getBookStoreList() {
//        List<BookStore> bookStoreList = bookStoreRepository.findAll();
//        return bookStoreList.stream().map(BookStoreResponseDto::new).collect(Collectors.toList());
//    }

}
