package com.example.bookstore.service;

import com.example.bookstore.domain.Board;
import com.example.bookstore.domain.Heart;
import com.example.bookstore.domain.Reply;
import com.example.bookstore.domain.User;
import com.example.bookstore.repository.BoardRepository;
import com.example.bookstore.repository.HeartRepository;
import com.example.bookstore.repository.ReplyRepository;
import com.example.bookstore.repository.UserRepository;
import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
public class BoardServiceTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    HeartRepository heartRepository;
    @Autowired
    BoardRepository boardRepository;
    @Autowired
    ReplyRepository replyRepository;

    @Autowired
    EntityManager em;

    @Test
    public void deleteBoard() {
        User user = userRepository.save(new User(1L, "닉네임", 10));
        User user2 = userRepository.save(new User(2L, "닉네임1", 20));
        Board board = boardRepository.save(new Board("제목", "내용", user));
        Reply r1 = replyRepository.save(new Reply("내용1", board, user2));
        Reply r2 = replyRepository.save(new Reply("내용2", board, user2));
        heartRepository.save(new Heart(user2, board));

        em.flush();
        em.clear();

        Long boardId = board.getId();
        boardRepository.deleteById(boardId);

        assertThat(boardRepository.findById(boardId)).isEqualTo(Optional.empty());
        System.out.println(r1.getContent());

    }
}
