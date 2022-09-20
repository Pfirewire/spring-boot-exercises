package com.codeup.springbootexercises.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String landingPage() {
        return "posts/index";
    }
}
