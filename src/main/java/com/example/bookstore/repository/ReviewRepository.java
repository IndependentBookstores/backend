package com.example.bookstore.repository;


import com.example.bookstore.domain.Blog;
import com.example.bookstore.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByBookStoreId(Long bookStoreId);
}
