package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Geonguk Han
 * @since 2020-06-18
 */
@Controller
public class HomeController {


    @GetMapping("/")
    public String home() {
        return "home";
    }
}
