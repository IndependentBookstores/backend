package com.example.bookstore.repository;

import com.example.bookstore.domain.Blog;
import com.example.bookstore.domain.BookStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface BlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findByBookStoreId(Long bookStoreId);

}
