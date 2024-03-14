package com.example.bookstore.service;

import com.amazonaws.services.kms.model.NotFoundException;
import com.example.bookstore.domain.Review;
import com.example.bookstore.dto.ReviewRequestDto;
import com.example.bookstore.dto.ReviewResponseDto;
import com.example.bookstore.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class ReviewService {

    private final ReviewRepository reviewRepository;

    //리뷰 생성
    @Transactional
    public Long save(ReviewRequestDto reviewRequestDto) {
        return reviewRepository.save(reviewRequestDto.toEntity()).getId();
    }

    //리뷰 수정
    @Transactional
    public Long update(Long reviewId, ReviewRequestDto reviewRequestDto) {
        Review review = reviewRepository.findById(reviewId).orElseThrow(() -> new NotFoundException("해당 리뷰를 찾을 수 없습니다."));
        review.updateReview(reviewRequestDto);
        return reviewId;
    }

    //리뷰 삭제
    @Transactional
    public void delete(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    //서점 상세정보에 있는 리뷰 조회
    public List<ReviewResponseDto> getReviews(Long bookStoreId) {
        List<Review> reviews = reviewRepository.findByBookStoreId(bookStoreId);
        return reviews.stream().map(ReviewResponseDto::new).collect(Collectors.toList());
    }
}
