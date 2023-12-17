package com.example.bookstore.repository;

import com.example.bookstore.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BoardRepository extends JpaRepository<Board, Long> {
}
