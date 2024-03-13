package com.example.bookstore.repository;

import com.example.bookstore.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;


public interface BoardRepository extends JpaRepository<Board, Long> {

    @Modifying
    @Query("update Board b set b.likeCount= b.likeCount+1 where b.id = :boardId")
    void addLikeCount(Long boardId);

    @Modifying
    @Query("update Board b set b.likeCount= b.likeCount-1 where b.id = :boardId")
    void subLikeCount(Long boardId);

    @Query("select b from Board b where b.modifiedDate >= :oneWeekAgo")
    List<Board> bestBoards(String oneWeekAgo, Pageable pageable);

    List<Board> findAllByUserId(Long userId);

}
