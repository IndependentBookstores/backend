package com.example.bookstore.repository;


import com.example.bookstore.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReviewRepository extends JpaRepository<Review, Long> {
}
