package com.example.bookstore.service;

import com.amazonaws.services.kms.model.NotFoundException;
import com.example.bookstore.domain.*;
import com.example.bookstore.dto.BoardResponseDto;
import com.example.bookstore.repository.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired UserRepository userRepository;
    @Autowired BoardRepository boardRepository;
    @Autowired ReplyRepository replyRepository;
    @Autowired HeartRepository heartRepository;
    @Autowired ReviewRepository reviewRepository;

    @Autowired
    BookStoreRepository bookStoreRepository;

    @Autowired
    UserService userService;

    @Autowired
    BoardService boardService;

    @Test
    public void deleteUser() {
        User user = userRepository.save(new User(1L, "유저", 20));
        User user2 = userRepository.save(new User(2L,"유저2", 20));
        Board b1  = boardRepository.save(new Board("제목1", "내용1", user));
        Board b2 = boardRepository.save(new Board("제목2", "내용2", user));
        Board b3 = boardRepository.save(new Board("제목3", "내용3", user2));
        Reply r1 = replyRepository.save(new Reply("댓글1", b3, user));
        Reply r2 = replyRepository.save(new Reply("댓글2", b3, user));
        Heart heart = heartRepository.save(new Heart(user, b3));
        BookStore bookStore = bookStoreRepository.save(new BookStore("서점1"));
        BookStore bookStore2 = bookStoreRepository.save(new BookStore("서점2"));
        Review rv1 = reviewRepository.save(new Review("서점리뷰1", "null", user, bookStore));
        Review rv2 = reviewRepository.save(new Review("서점리뷰2", "null", user, bookStore2));

        Long userId = user.getId();

        userService.delete(userId);

        assertThat(b1.getUser()).isEqualTo(null);
        assertThat(b2.getUser()).isEqualTo(null);
        assertThat(r1.getUser()).isEqualTo(null);
        assertThat(r2.getUser()).isEqualTo(null);
        assertThat(heartRepository.findAllByUserId(userId).size()).isEqualTo(0);
        assertThat(rv1.getUser()).isEqualTo(null);
        assertThat(rv2.getUser()).isEqualTo(null);

        assertThat(userRepository.findById(userId)).isEqualTo(Optional.empty());

    }

    @Test
    public void checkNickname() {
        User user = userRepository.save(new User(1L, "유저1", 20));
        Boolean checkNickname = userService.checkNickname("유저1");

        assertThat(checkNickname).isTrue();

    }
}