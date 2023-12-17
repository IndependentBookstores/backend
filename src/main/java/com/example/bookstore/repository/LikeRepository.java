package com.example.bookstore.repository;

import com.example.bookstore.domain.Like;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LikeRepository extends JpaRepository<Like, Long> {
}
