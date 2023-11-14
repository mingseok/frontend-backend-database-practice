package com.example.frontendbackenddatabasepractice.mapper;

import com.example.frontendbackenddatabasepractice.domain.Member;
import com.example.frontendbackenddatabasepractice.dto.MemberDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberMapper {

    List<Member> memberList();

    void joinMember(MemberDto memberDto);

    void updateMember(MemberDto memberDto);

    Member getMember(int id);

    void deleteMember(int id);
}