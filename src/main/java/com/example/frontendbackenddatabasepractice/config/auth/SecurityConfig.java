package com.example.frontendbackenddatabasepractice.config.auth;

import com.example.frontendbackenddatabasepractice.domain.user.Role;
import com.example.frontendbackenddatabasepractice.service.CustomOAuth2UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity // security 설정들을 활성화시켜 준다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    public SecurityConfig(CustomOAuth2UserService customOAuth2UserService) {
        this.customOAuth2UserService = customOAuth2UserService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // h2-console 화면을 사용하기 위해 해당 옵션들을 비활성 한다.
                .csrf().disable().headers().frameOptions().disable()

                .and()

                // url별 권한 관리를 설정하는 옵션의 시작점이다.
                // authorizeRequests가 선언되어야만, antMatchers 옵션들을 사용 할 수 있다.
                .authorizeRequests()

                // 권한 관리 대상을 지정하는 옵션이다.
                // url, http 메소드별로 관리가 가능하다.
                // "/" 등 지정된 url들은 permitAll() 옵션을 통해 전체 열람 권한을 주었다.
                // "/api/v1/**" 주소를 가진 api는 user 권한을 가진 사람만 가능하도록 한다.
                .antMatchers("/", "/sign-up", "/css/**", "/images/**", "/js/**", "/h2-console/**")
                .permitAll()
                .antMatchers("/api/v1/**", "/test").hasRole(Role.GUEST.name())

                // 설정된 값들 이외 나머지 url들을 나타내는 곳이다.
                // 여기서는 authenticated을 추가하여 나머지 url들은 모두 'user'권한인 사용자들에게만 허용하게 한다.
                .anyRequest().authenticated()

                .and()

                // 로그아웃 기능에 대한 여러 설정의 진입점이다.
                // 로그아웃 성공시 / 주소로 이동한다.
                .logout().logoutSuccessUrl("/")

                .and()

                // 소셜 로그인 성공 시 후속 조치를 진행할 userService 인터페이스의 구현체를 등록한다.
                // 추가로 진행하고자 하는 기능을 명시할 수 있다.
                .oauth2Login()

                .userInfoEndpoint().userService(customOAuth2UserService);
    }
}