package com.example.bookstore.repository;

import com.example.bookstore.domain.BookStore;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookStoreRepository extends JpaRepository<BookStore, Long> {

}
