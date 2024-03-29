package com.example.bookstore.repository;

import com.example.bookstore.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByNickname(String nickname);
}
