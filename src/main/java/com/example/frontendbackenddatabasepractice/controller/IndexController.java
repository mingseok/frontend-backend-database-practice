package com.example.frontendbackenddatabasepractice.controller;

import com.example.frontendbackenddatabasepractice.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

import com.example.frontendbackenddatabasepractice.config.auth.SessionUser;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final MemberService memberService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("members", memberService.memberList());
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "members/index";
    }

    @GetMapping("/logout")
    public String logout() {
        return "logouttt";
    }
}
