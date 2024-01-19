package com.example.bookstore.service;

import com.example.bookstore.domain.Review;
import com.example.bookstore.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class ReviewService {

    private final ReviewRepository reviewRepository;

    //리뷰 생성
    @Transactional
    public Long save(Review review) {
        return reviewRepository.save(review).getId();
    }
}
