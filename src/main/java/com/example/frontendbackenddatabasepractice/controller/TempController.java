package com.example.frontendbackenddatabasepractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempController {

    @GetMapping("/temp/jsp")
    public String tempJsp() {
        return "test";
    }
}