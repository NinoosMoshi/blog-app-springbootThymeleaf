package com.ninos.controller;

import com.ninos.model.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FormController {


    // handle registration
    @GetMapping("/register")
    public String userRegistration(Model model){
        UserForm userForm = new UserForm();
        model.addAttribute("userFormTemp", userForm);

        List<String> listProfession = List.of("Developer", "Tester", "Designer");
        model.addAttribute("listProfessionTemp", listProfession);

        return "register-form";
    }


    @PostMapping("/register/save")
    public String submitForm(Model model, @ModelAttribute("userFormTemp") UserForm userForm){
        model.addAttribute("userFormSuccess", userForm);
        return "register-success";
    }


}
