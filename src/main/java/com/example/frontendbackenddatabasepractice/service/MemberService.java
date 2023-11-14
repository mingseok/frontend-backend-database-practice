package com.example.frontendbackenddatabasepractice.service;

import com.example.frontendbackenddatabasepractice.dto.MemberDto;
import com.example.frontendbackenddatabasepractice.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.frontendbackenddatabasepractice.domain.Member;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;

    public void joinMember(MemberDto memberDto) {
        memberDto.changeJoinDate();
        memberMapper.joinMember(memberDto);
    }

    public List<Member> memberList() {
        return memberMapper.memberList();
    }
}