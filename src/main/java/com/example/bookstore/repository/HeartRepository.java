package com.example.bookstore.repository;

import com.example.bookstore.domain.Heart;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HeartRepository extends JpaRepository<Heart, Long> {
}
