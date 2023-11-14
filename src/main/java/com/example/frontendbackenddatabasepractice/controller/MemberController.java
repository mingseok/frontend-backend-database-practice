package com.example.frontendbackenddatabasepractice.controller;

import com.example.frontendbackenddatabasepractice.dto.MemberDto;
import com.example.frontendbackenddatabasepractice.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/list")
    public String main(Model model) {
        model.addAttribute("list", memberService.memberList());
        return "members/list";
    }

    @GetMapping("/sign-up")
    public String signUp(Model model) {

        model.addAttribute("memberDto", new MemberDto());
        return "members/sign-up";
    }

    @PostMapping("/sign-up")
    public String signUp(@ModelAttribute MemberDto memberDto) {
        log.info("memberDto =", memberDto);

        memberService.joinMember(memberDto);
        return "redirect:/list";
    }

}