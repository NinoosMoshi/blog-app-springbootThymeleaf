package com.ninos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {

    // http://localhost:8080/hello
    @GetMapping("/hello")
    public String helloWorld(Model model){
        model.addAttribute("message","hello world from ninos");
        return "hello";
    }


}
