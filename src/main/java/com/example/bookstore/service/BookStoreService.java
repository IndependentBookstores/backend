package com.example.bookstore.service;

import com.example.bookstore.domain.BookStore;
import com.example.bookstore.dto.BookStoreDto;
import com.example.bookstore.repository.BookStoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class BookStoreService {

    private final BookStoreRepository bookStoreRepository;

    //서점 상세정보
    public BookStoreDto getBookStore(Long bookStoreId) {
        BookStore bookStore = bookStoreRepository.findById(bookStoreId).orElseThrow(()->new IllegalArgumentException("해당 서점이 없습니다."));
        log.info("bookStore={}", bookStore);
        return new BookStoreDto(bookStore);
    }
}
