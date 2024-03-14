package com.example.bookstore.repository;


import com.example.bookstore.domain.Reply;
import com.example.bookstore.dto.ReplyResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ReplyRepository extends JpaRepository<Reply, Long> {



    List<Reply> findAllByBoardId(Long boardId);

    List<Reply> findAllByUserId(Long userId);
}
