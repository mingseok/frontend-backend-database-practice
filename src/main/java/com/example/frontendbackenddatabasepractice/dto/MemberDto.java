package com.example.frontendbackenddatabasepractice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private int id;
    private String loginId;
    private String memberPwd;
    private String memberName;
    private LocalDateTime joinDate;

    public void changeJoinDate() {
        this.joinDate = LocalDateTime.now();
    }
}
