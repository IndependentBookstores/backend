package com.example.bookstore.service;

import com.example.bookstore.domain.Blog;
import com.example.bookstore.domain.BookStore;
import com.example.bookstore.domain.Review;
import com.example.bookstore.dto.BookStoreDetailDto;
import com.example.bookstore.repository.BlogRepository;
import com.example.bookstore.repository.BookStoreRepository;
import com.example.bookstore.repository.ReviewRepository;
import com.example.bookstore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        Long id = bookStore.getId();
        List<Blog> blogs = blogRepository.findByBookStoreId(id);
        List<Review> reviews = reviewRepository.findByBookStoreId(id);
        return new BookStoreDetailDto(bookStore, blogs, reviews);
    }
}
