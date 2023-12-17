package com.example.bookstore.repository;


import com.example.bookstore.domain.Reply;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
