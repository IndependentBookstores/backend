//package com.example.bookstore.controller;
//
//import com.example.bookstore.domain.User;
//import com.example.bookstore.service.CustomOAuth2UserService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@Slf4j
//@RequiredArgsConstructor
//@RestController
//public class LoginController {
//
//    private final CustomOAuth2UserService customOAuth2UserService;
//
//    @GetMapping("/user")
//    public OAuth2User getUserDetails(@AuthenticationPrincipal OAuth2User principal) {
//        return customOAuth2UserService.loadUser((OAuth2UserRequest) principal.getAttributes().get("oauth2Request"));
//    }
//
//}
