package com.example.bookstore.service;

import com.amazonaws.services.kms.model.NotFoundException;
import com.example.bookstore.domain.Board;
import com.example.bookstore.domain.Heart;
import com.example.bookstore.domain.User;
import com.example.bookstore.dto.*;
import com.example.bookstore.repository.BoardRepository;
import com.example.bookstore.repository.HeartRepository;
import com.example.bookstore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class BoardService {

    private final BoardRepository boardRepository;

    private final HeartRepository heartRepository;

    private final UserRepository userRepository;

    //글 생성
    @Transactional
    public Long save(BoardRequestDto boardRequestDto){
        return boardRepository.save(boardRequestDto.toEntity()).getId();
    }

    //글 수정
    @Transactional
    public Long update(Long boardId, BoardRequestDto boardRequestDto){
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new NotFoundException("글이 존재하지 않습니다."));
        board.updateBoard(boardRequestDto);
        return boardId;
    }

    //글 전체 조회
    public List<BoardResponseDto> findAll() {
        List<Board> boards = boardRepository.findAll();
        return boards.stream().map(BoardResponseDto::new).collect(Collectors.toList());
    }

    //선택한 글 조회
    public BoardDetailDto findById(Long boardId, Long userId) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new NotFoundException("해당 글이 없습니다"));
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("유저를 찾을 수 없습니다."));
        Optional<Heart> heart = heartRepository.findByUserAndBoard(user, board);
        if (heart.isPresent()) {
            return new BoardDetailDto(board, true);
        } else {
            return new BoardDetailDto(board, false);
        }
    }

    //인기 글 조회(일주일 이내 작성 글, 3개)
    public List<BestBoardDto> bestBoards() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        c.add(Calendar.DATE, -7);
        String oneWeekAgo = sdf.format(c.getTime());


        PageRequest pageRequest = PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "likeCount"));

        List<Board> boards = boardRepository.bestBoards(oneWeekAgo, pageRequest);
        return boards.stream().map(BestBoardDto::new).collect(Collectors.toList());
    }

    //좋아요 누른 글 조회
    public List<HeartBoardDto> heartBoards(Long userId) {
        List<Heart> hearts = heartRepository.heartBoards(userId);

        return hearts.stream().map(HeartBoardDto::new).collect(Collectors.toList());
    }
}
