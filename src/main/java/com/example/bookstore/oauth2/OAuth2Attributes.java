//package com.example.bookstore.oauth2;
//import com.example.bookstore.domain.User;
//import lombok.Builder;
//import lombok.Getter;
//
//import java.util.Map;
//
//@Getter
//@Builder
//public class OAuth2Attributes {
//    private Map<String, Object> attributes;
//    private String nameAttributeKey;
//    private String id;
//
//    public static OAuth2Attributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
//        if("naver".equals(registrationId)) {
//            return ofNaver("id", attributes);
//        } else if ("kakao".equals(registrationId)) {
//            return ofKakao("id", attributes);
//        }
//
//        return ofGoogle(userNameAttributeName, attributes);
//    }
//
//    private static OAuth2Attributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
//        return OAuth2Attributes.builder()
//                .id((String) attributes.get("sub"))
//                .attributes(attributes)
//                .nameAttributeKey(userNameAttributeName)
//                .build();
//    }
//
//    private static OAuth2Attributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
//        Map<String, Object> response = (Map<String, Object>) attributes.get("response");
//
//        return OAuth2Attributes.builder()
//                .id((String) response.get("id"))
//                .attributes(response)
//                .nameAttributeKey(userNameAttributeName)
//                .build();
//    }
//
//    private static OAuth2Attributes ofKakao(String userNameAttributeName, Map<String, Object> attributes) {
//        Map<String, Object> response = (Map<String, Object>) attributes.get("kakao_account");
////        Map<String, Object> account = (Map<String, Object>) attributes.get("profile");
//
//        return OAuth2Attributes.builder()
//                .id((String) response.get("id"))
//                .attributes(response)
//                .nameAttributeKey(userNameAttributeName)
//                .build();
//    }
//
//    public User toEntity() {
//        return User.builder()
//                .id(id)
//                .build();
//    }
//}