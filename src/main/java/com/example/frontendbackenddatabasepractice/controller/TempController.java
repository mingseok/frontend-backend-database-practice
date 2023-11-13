package com.example.frontendbackenddatabasepractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempController {

    @GetMapping("/temp/jsp")
    public String tempJsp() {
        // prefix: /WEB-INF/views
        // suffix: .jsp
        // 풀경로: /WEB-INF/views/test.jsp
        return "test";
    }
}