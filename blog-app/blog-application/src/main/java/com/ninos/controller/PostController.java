package com.ninos.controller;

import com.ninos.dto.PostDTO;
import com.ninos.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PostController {


    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }


    @GetMapping("/admin/posts")
    public String posts(Model model){
        List<PostDTO> postDTOList = postService.findAllPosts();
        model.addAttribute("postsDtoList", postDTOList);
        return "/admin/posts";
    }




}
