package com.example.bookstore.service;

import com.example.bookstore.domain.Blog;
import com.example.bookstore.dto.BlogDto;
import com.example.bookstore.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class BlogService {

    private final BlogRepository blogRepository;

    //서점 상세정보에 있는 블로그 조회
    public List<BlogDto> getBlogs(Long bookStoreId) {
        List<Blog> blogs = blogRepository.findByBookStoreId(bookStoreId);
        return blogs.stream().map(BlogDto::new).collect(Collectors.toList());
    }
}
