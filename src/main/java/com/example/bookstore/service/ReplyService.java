package com.example.bookstore.service;

import com.example.bookstore.domain.Reply;
import com.example.bookstore.dto.BoardResponseDto;
import com.example.bookstore.dto.ReplyRequestDto;
import com.example.bookstore.dto.ReplyResponseDto;
import com.example.bookstore.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class ReplyService {

    private final ReplyRepository replyRepository;

    //댓글 생성
    @Transactional
    public Long save(ReplyRequestDto replyRequestDto) {
        return replyRepository.save(replyRequestDto.toEntity()).getId();
    }

    //글에 해당하는 댓글 조회
    public List<ReplyResponseDto> findByBoardId(Long boardId) {
        List<Reply> replies = replyRepository.findAllByBoardId(boardId);
        return replies.stream().map(ReplyResponseDto::new).collect(Collectors.toList());
    }

}
