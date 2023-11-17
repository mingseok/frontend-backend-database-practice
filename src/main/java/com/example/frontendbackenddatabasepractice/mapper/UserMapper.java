package com.example.frontendbackenddatabasepractice.mapper;

import com.example.frontendbackenddatabasepractice.domain.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User findByEmail(String email);

    void save(User user);

    String findByRole(int id);
}