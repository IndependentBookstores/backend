package com.example.bookstore.repository;

import com.example.bookstore.domain.Board;
import com.example.bookstore.domain.Heart;
import com.example.bookstore.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface HeartRepository extends JpaRepository<Heart, Long> {

    Optional<Heart> findByUserAndBoard(User user, Board board);

    @Query("select h from Heart h left join fetch h.board where h.user.id = :userId")
    List<Heart> heartBoards(Long userId);


}
