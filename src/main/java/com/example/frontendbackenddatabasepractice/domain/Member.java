package com.example.frontendbackenddatabasepractice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private int id;
    private String loginId;
    private String memberPwd;
    private String memberName;
    private LocalDateTime joinDate;
}
