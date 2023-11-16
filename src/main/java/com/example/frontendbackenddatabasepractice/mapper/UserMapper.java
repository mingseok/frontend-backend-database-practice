package com.example.frontendbackenddatabasepractice.mapper;

import com.example.frontendbackenddatabasepractice.domain.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    //로그인 & 회원가입
    User findByEmail(String email);

    void save(User user);
}