package com.example.bookstore.repository;


import com.example.bookstore.domain.Reply;
import com.example.bookstore.dto.ReplyResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ReplyRepository extends JpaRepository<Reply, Long> {

    List<Reply> findAllByBoardId(Long boardId);
}
