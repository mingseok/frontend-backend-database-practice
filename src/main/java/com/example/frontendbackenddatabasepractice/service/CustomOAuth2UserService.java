package com.example.frontendbackenddatabasepractice.service;

import com.example.frontendbackenddatabasepractice.config.auth.OAuthAttributes;
import com.example.frontendbackenddatabasepractice.config.auth.SessionUser;
import com.example.frontendbackenddatabasepractice.domain.user.User;
import com.example.frontendbackenddatabasepractice.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Collections;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    private final UserMapper userMapper;
    private final HttpSession httpSession;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();

        // 현재 로그인 진행 중인 서비스를 구분하는 코드
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        // 현재 로그인 진행 중인 서비스를 구분하는 코드
        String registrationId = userRequest.getClientRegistration().getRegistrationId();

        // OAuth2 로그인 진행 시 키가 되는 필드값을 이야기 한다.
        // 네이버 로그인과 구글 로그인을 동시 지원할 때 사용한다.
        String userNameAttributeName = userRequest.getClientRegistration()
                                                .getProviderDetails()
                                                .getUserInfoEndpoint()
                                                .getUserNameAttributeName();

        // OAuthAttributes: attribute를 담을 클래스 (개발자가 생성)
        OAuthAttributes attributes = OAuthAttributes.of(registrationId,
                                                        userNameAttributeName,
                                                        oAuth2User.getAttributes());
        User user = saveOrUpdate(attributes);

        // SessioUser: 세션에 사용자 정보를 저장하기 위한 DTO 클래스 (개발자가 생성)
        httpSession.setAttribute("user", new SessionUser(user));

        return new DefaultOAuth2User(Collections.singleton(new SimpleGrantedAuthority(user.getRoleKey())),
                                                                                        attributes.getAttributes(),
                                                                                        attributes.getNameAttributeKey());
    }

    private User saveOrUpdate(OAuthAttributes attributes) {
        User user;

        if (userMapper.findByEmail(attributes.getEmail()) != null) {
            user = userMapper.findByEmail(attributes.getEmail());
        } else {
            user = attributes.toEntity();
            userMapper.save(user);
            user = userMapper.findByEmail(attributes.getEmail());
        }

        return user;
    }

    public String findByRole() {
        // 테스트라서 5로 지정했다.
        return userMapper.findByRole(5);
    }
}