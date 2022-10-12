package com.ninos.controller;

import com.ninos.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    // http://localhost:8080/variable
    @GetMapping("/variable")
    public String variableExpression(Model model){
        User user = new User("ninos","ninos@gmail.com","admin","male");
        model.addAttribute("tempUser",user);
        return "variable";
    }

    // http://localhost:8080/selection
    @GetMapping("/selection")
    public String selectionExpression(Model model){
        User user = new User("ninos","ninos@gmail.com","admin","male");
        model.addAttribute("tempUser",user);
        return "selection";
    }


    // http://localhost:8080/message
    @GetMapping("/message")
    public String messageExpression(){
        return "message";
    }


    // http://localhost:8080/link
    @GetMapping("/link")
    public String linkExpression(Model model){
        model.addAttribute("modelId", 1);
        return "link";
    }


    // http://localhost:8080/fragment
    @GetMapping("/fragment")
    public String fragmentExpression(){
        return "fragment";
    }


    // http://localhost:8080/each
    @GetMapping("/each")
    public String eachExpression(Model model){

        List<User> list = new ArrayList<>();
        list.add(new User("ninos","ninos@gmail.com","admin","male"));
        list.add(new User("nahrain","nahrain@gmail.com","admin","female"));
        list.add(new User("matthew","matthew@gmail.com","admin","male"));
        list.add(new User("daniel","daniel@gmail.com","admin","male"));

        model.addAttribute("eachUser",list);
        return "each";
    }

    // http://localhost:8080/each
    @GetMapping("/if-unless")
    public String ifUnlessExpression(Model model){

        List<User> list = new ArrayList<>();
        list.add(new User("ninos","ninos@gmail.com","admin","male"));
        list.add(new User("nahrain","nahrain@gmail.com","user","female"));
        list.add(new User("matthew","matthew@gmail.com","admin","male"));
        list.add(new User("daniel","daniel@gmail.com","user","male"));

        model.addAttribute("ifUser",list);
        return "if_unless";
    }


    // http://localhost:8080/switch
    @GetMapping("/switch")
    public String switchExpression(Model model){
        User user = new User("ninos","ninos@gmail.com","admin","male");
        model.addAttribute("tempUser",user);
        return "switch";
    }


}
