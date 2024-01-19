//package com.example.bookstore.service;
//
//import com.example.bookstore.domain.User;
//import com.example.bookstore.oauth2.OAuth2Attributes;
//import com.example.bookstore.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
//import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
//import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Collections;
//
//
//@Slf4j
//@RequiredArgsConstructor
//@Transactional
//@Service
//public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
//
//    private final UserRepository userRepository;
//
//    @Override
//    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
//        OAuth2UserService<OAuth2UserRequest, OAuth2User> oAuth2UserService = new DefaultOAuth2UserService();
//        OAuth2User oAuth2User = oAuth2UserService.loadUser(oAuth2UserRequest);
//
//        //OAuth 서비스 이름 ex)구글, 네이버, 카카오 등
//        String registrationId = oAuth2UserRequest.getClientRegistration().getRegistrationId();
//        //OAuth 로그인 시 키 값. 구글, 네이버, 카카오 등 각 다르기 때문에 변수로 받아서 넣음
//        String userNameAttributeName = oAuth2UserRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();
//
//        OAuth2Attributes oAuth2Attributes = OAuth2Attributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());
//
//        User user = saveOrUpdate(oAuth2Attributes);
//
//        return new DefaultOAuth2User(
//                Collections.singleton(new SimpleGrantedAuthority(user.getId())),
//                oAuth2Attributes.getAttributes(),
//                oAuth2Attributes.getNameAttributeKey()
//        );
//
//    }
//    private User saveOrUpdate(OAuth2Attributes attributes) {
//        User user = userRepository.findById(attributes.getId())
//                .orElse(attributes.toEntity());
//
//        return userRepository.save(user);
//    }
//
//}
