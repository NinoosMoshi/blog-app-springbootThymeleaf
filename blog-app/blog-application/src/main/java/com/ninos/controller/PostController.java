package com.ninos.controller;

import com.ninos.dto.PostDTO;
import com.ninos.service.PostService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Locale;

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


    @GetMapping("/admin/posts/newpost")
    public String newPostForm(Model model){
       PostDTO postDTO = new PostDTO();
       model.addAttribute("postTemp", postDTO);
       return "admin/create_post";
    }

    @PostMapping("/admin/posts")
    public String createPost(@Valid @ModelAttribute("postTemp") PostDTO postDTO, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("postTemp", postDTO);
            return "admin/create_post";
        }
       postDTO.setUrl(getUrl(postDTO.getTitle()));
       postService.createPost(postDTO);
       return "redirect:/admin/posts";
    }

    private static String getUrl(String postTitle){
        String title = postTitle.trim().toLowerCase();
        String url = title.replaceAll("\\s+","-");
        url = url.replaceAll("[^A-Za-z0-9]", "-");
        return url;
    }



}
