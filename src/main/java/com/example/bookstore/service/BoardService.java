package com.example.bookstore.service;

import com.example.bookstore.domain.Board;
import com.example.bookstore.dto.BoardRequestDto;
import com.example.bookstore.dto.BoardResponseDto;
import com.example.bookstore.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class BoardService {

    private final BoardRepository boardRepository;
    private final AmazonS3Service amazonS3Service;

    //글 생성
    @Transactional
    public Long save(BoardRequestDto boardRequestDto, MultipartFile image) throws IOException {
        String imageUrl = "";
        if (image != null) {
            imageUrl = amazonS3Service.upload(image);
        }
        return boardRepository.save(boardRequestDto.toEntity(imageUrl)).getId();
    }

    //글 전체 조회
    public List<BoardResponseDto> findAll() {
        List<Board> boards = boardRepository.findAll();
        return boards.stream().map(BoardResponseDto::new).collect(Collectors.toList());
    }

    //선택한 글 조회
    public BoardResponseDto findById(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 글이 없습니다"));
        return new BoardResponseDto(board);
    }
}
