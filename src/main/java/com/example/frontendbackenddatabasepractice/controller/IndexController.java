package com.example.frontendbackenddatabasepractice.controller;

import com.example.frontendbackenddatabasepractice.service.CustomOAuth2UserService;
import com.example.frontendbackenddatabasepractice.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

import com.example.frontendbackenddatabasepractice.config.auth.SessionUser;

@Slf4j
@RequiredArgsConstructor
@Controller
public class IndexController {

    private final CustomOAuth2UserService customOAuth2UserService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model) {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

        String role = customOAuth2UserService.findByRole();
        log.info("role = {}", role);

        if (role != null && role.equals("USER")) {
            model.addAttribute("role", role);
        }


        return "members/index";
    }

    @GetMapping("/test")
    public String privilege() {
        return "members/test";
    }
}
