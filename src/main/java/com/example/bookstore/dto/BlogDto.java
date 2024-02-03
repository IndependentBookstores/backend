package com.example.bookstore.dto;

import com.example.bookstore.domain.Blog;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class BlogDto {

    private String title;

    private String content;

    private String link;

    private String author;

    private String name;

    private String date;

    public BlogDto(Blog blog) {
        this.title = blog.getTitle();
        this.content = blog.getContent();
        this.link = blog.getLink();
        this.author = blog.getAuthor();
        this.name = blog.getName();
        this.date = blog.getDate();
    }

}
