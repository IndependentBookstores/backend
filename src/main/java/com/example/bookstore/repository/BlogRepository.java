package com.example.bookstore.repository;

import com.example.bookstore.domain.Blog;
import com.example.bookstore.domain.BookStore;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BlogRepository extends JpaRepository<Blog, Long> {
}
