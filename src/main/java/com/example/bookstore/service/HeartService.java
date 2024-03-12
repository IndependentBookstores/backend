package com.example.bookstore.service;

import com.amazonaws.services.kms.model.NotFoundException;
import com.example.bookstore.domain.Board;
import com.example.bookstore.domain.Heart;
import com.example.bookstore.domain.User;
import com.example.bookstore.dto.HeartRequestDto;
import com.example.bookstore.repository.BoardRepository;
import com.example.bookstore.repository.HeartRepository;
import com.example.bookstore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class HeartService {

    private final HeartRepository heartRepository;
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    //좋아요 로직
    @Transactional
    public Boolean save(HeartRequestDto heartRequestDto) {
        User user = userRepository.findById(heartRequestDto.getUserId()).orElseThrow(() -> new NotFoundException("유저를 찾을 수 없습니다. " + heartRequestDto.getUserId()));
        Board board = boardRepository.findById(heartRequestDto.getBoardId()).orElseThrow(() -> new NotFoundException("글을 찾을 수 없습니다. " + heartRequestDto.getBoardId()));

        Optional<Heart> likeBoard = heartRepository.findByUserAndBoard(user, board);

        if (likeBoard.isPresent()) {
            boardRepository.subLikeCount(likeBoard.get().getId());
            heartRepository.delete(heartRequestDto.toEntity());
            return false;
        } else {
            heartRepository.save(heartRequestDto.toEntity());
            boardRepository.addLikeCount(board.getId());
            return true;
        }
    }

    @Transactional
    public void delete(HeartRequestDto heartRequestDto) {
        User user = userRepository.findById(heartRequestDto.getUserId()).orElseThrow(() -> new NotFoundException("유저를 찾을 수 없습니다. " + heartRequestDto.getUserId()));
        Board board = boardRepository.findById(heartRequestDto.getBoardId()).orElseThrow(() -> new NotFoundException("글을 찾을 수 없습니다. " + heartRequestDto.getBoardId()));
        Heart heart = heartRepository.findByUserAndBoard(user, board).orElseThrow(() -> new NotFoundException("좋아요를 찾을 수 없습니다"));
        heartRepository.delete(heart);
    }

}
