package com.ninos.controller;

import com.ninos.dto.PostDTO;
import com.ninos.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BlogController {

    private PostService postService;

    public BlogController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String viewPosts(Model model){
        List<PostDTO> postResponse = postService.findAllPosts();
        model.addAttribute("postResponse",postResponse);
        return "blog/view_posts";
    }


    @GetMapping("/post/{postUrl}")
    public String showPost(@PathVariable("postUrl") String postUrl, Model model){
        PostDTO postByUrl = postService.findPostByUrl(postUrl);
        model.addAttribute("postUrlTemp", postByUrl);
        return "blog/blog_post";
    }

    // http://localhost:8080/page/search?word=java
    @GetMapping("/page/search")
    public String searchBlog(@RequestParam("word") String word, Model model){
        List<PostDTO> searchPosts = postService.searchPosts(word);
        model.addAttribute("postResponse", searchPosts);
        return "blog/view_posts";
    }





}
