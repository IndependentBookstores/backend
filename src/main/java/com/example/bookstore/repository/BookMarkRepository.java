package com.example.bookstore.repository;

import com.example.bookstore.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookMarkRepository extends JpaRepository<BookMark, Long> {

    Optional<BookMark> findByUserAndBookStore(User user, BookStore bookStore);

    List<BookMark> findAllByUserId(Long userId);

}
