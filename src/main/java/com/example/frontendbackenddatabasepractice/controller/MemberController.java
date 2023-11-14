package com.example.frontendbackenddatabasepractice.controller;

import com.example.frontendbackenddatabasepractice.domain.Member;
import com.example.frontendbackenddatabasepractice.dto.MemberDto;
import com.example.frontendbackenddatabasepractice.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    // 사용자들의 리스트 보기
    @GetMapping("/list")
    public String main(Model model) {
        model.addAttribute("list", memberService.memberList());
        return "members/list";
    }

    // 사용자 등록
    @GetMapping("/sign-up")
    public String signUp(Model model) {
        model.addAttribute("memberDto", new MemberDto());
        return "members/sign-up";
    }

    // 사용자 등록
    @PostMapping("/sign-up")
    public String signUp(@ModelAttribute MemberDto memberDto) {
        log.info("memberDto ={}", memberDto);

        memberService.joinMember(memberDto);
        return "redirect:/list";
    }

//
//    사용자 상세 보기 v2
//    @GetMapping("/view")
//    public String viewMember(@RequestParam int id) {
//        Member member = memberService.getMember(id);
//        model.addAttribute("member", member);
//        return "members/view";
//    }
//
//

    // 사용자 상세 보기 v2
    @GetMapping("/view/{id}")
    public String view(Model model, @PathVariable int id) {
        log.info("id = {}", id);
        Member member = memberService.getMember(id);
        model.addAttribute("member", member);
        return "members/view";
    }




    // TODO: 사용자 수정 만들어야함
    public String updateMemberForm(Model model, @PathVariable int id) {

        return "members/update";
    }

    // 사용자 수정
    @PostMapping("/update")
    public String update(@ModelAttribute MemberDto memberDto) {
        memberService.updateMember(memberDto);
        return "redirect:/list";
    }

}