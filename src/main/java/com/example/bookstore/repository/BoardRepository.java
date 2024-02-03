package com.example.bookstore.repository;

import com.example.bookstore.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface BoardRepository extends JpaRepository<Board, Long> {

    @Modifying
    @Query("update Board b set b.likeCount= b.likeCount+1 where b.id = :boardId")
    void addLikeCount(Long boardId);

    @Modifying
    @Query("update Board b set b.likeCount= b.likeCount-1 where b.id=:boardId")
    void subLikeCount(Long boardId);
}
