package com.example.bookstore.service;

import com.amazonaws.services.kms.model.NotFoundException;
import com.example.bookstore.domain.*;
import com.example.bookstore.dto.UserDto;
import com.example.bookstore.repository.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    private final ReplyRepository replyRepository;
    private final HeartRepository heartRepository;
    private final ReviewRepository reviewRepository;

    //유저 생성
    @Transactional
    public Long save(UserDto userDto){
        return userRepository.save(userDto.toEntity()).getId();
    }

    //유저 수정
    @Transactional
    public Long update(Long userId, UserDto userDto) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("해당 유저가 없습니다"));
        user.updateUser(userDto);
        return userId;
    }

    //닉네임 중복확인
    public Boolean checkNickname(String nickname) {
        Boolean checkNickname = userRepository.existsByNickname(nickname);
        return checkNickname;
    }

    //유저 정보 불러오기
    public UserDto findUser(Long userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("해당 유저가 없습니다"));
        return new UserDto(user);
    }

    @Transactional
    //유저 삭제
    public void delete(Long userId) {
        List<Board> boards = boardRepository.findAllByUserId(userId);
        if (boards.size() != 0) {
            for (Board board : boards) {
                board.deleteUser();
            }
        }

        List<Reply> replies = replyRepository.findAllByUserId(userId);
        if (replies.size() != 0) {
            for (Reply reply : replies) {
                reply.deleteUser();
            }
        }

        List<Review> reviews = reviewRepository.findAllByUserId(userId);
        if (reviews.size() != 0) {
            for (Review review : reviews) {
                review.deleteUser();
            }
        }
        List<Heart> hearts = heartRepository.findAllByUserId(userId);
        if (hearts.size() != 0) {
            for (Heart heart : hearts) {
                heartRepository.delete(heart);
            }
        }

        userRepository.deleteById(userId);

    }
}
