package com.example.bookstore.service;

import com.amazonaws.services.kms.model.NotFoundException;
import com.example.bookstore.domain.*;
import com.example.bookstore.dto.BookMarkRequestDto;
import com.example.bookstore.dto.BookMarkResponseDto;
import com.example.bookstore.dto.HeartRequestDto;
import com.example.bookstore.repository.BookMarkRepository;
import com.example.bookstore.repository.BookStoreRepository;
import com.example.bookstore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class BookMarkService {

    private final BookMarkRepository bookMarkRepository;
    private final UserRepository userRepository;
    private final BookStoreRepository bookStoreRepository;


    //북마크 저장
    @Transactional
    public Boolean save(BookMarkRequestDto bookMarkRequestDto) {
        User user = userRepository.findById(bookMarkRequestDto.getUserId()).orElseThrow(() -> new NotFoundException("유저를 찾을 수 없습니다. " + bookMarkRequestDto.getUserId()));
        BookStore bookStore = bookStoreRepository.findById(bookMarkRequestDto.getBookStoreId()).orElseThrow(() -> new NotFoundException("서점을 찾을 수 없습니다. " + bookMarkRequestDto.getBookStoreId()));

        Optional<BookMark> isBookMark = bookMarkRepository.findByUserAndBookStore(user, bookStore);

        if (isBookMark.isPresent()) {
            return false;
        } else {
            bookMarkRepository.save(bookMarkRequestDto.toEntity());
            return true;
        }
    }

    //북마크 한 서점 리스트 조회
    public List<BookMarkResponseDto> findAll(Long userId) {
        List<BookMark> bookMarks = bookMarkRepository.findAllByUserId(userId);
        return bookMarks.stream().map(BookMarkResponseDto::new).collect(Collectors.toList());
    }

    //북마크 삭제
    @Transactional
    public void delete(BookMarkRequestDto bookMarkRequestDto) {
        User user = userRepository.findById(bookMarkRequestDto.getUserId()).orElseThrow(() -> new NotFoundException("유저를 찾을 수 없습니다. " + bookMarkRequestDto.getUserId()));
        BookStore bookStore = bookStoreRepository.findById(bookMarkRequestDto.getBookStoreId()).orElseThrow(() -> new NotFoundException("서점을 찾을 수 없습니다. " + bookMarkRequestDto.getBookStoreId()));
        BookMark bookMark = bookMarkRepository.findByUserAndBookStore(user, bookStore).orElseThrow(() -> new NotFoundException("북마크를 찾을 수 없습니다"));
        bookMarkRepository.delete(bookMark);
    }
}
