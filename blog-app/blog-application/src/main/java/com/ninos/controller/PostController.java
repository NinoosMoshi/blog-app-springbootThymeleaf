package com.ninos.controller;

import com.ninos.dto.PostDTO;
import com.ninos.entity.Post;
import com.ninos.service.PostService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/admin/posts/{postId}/edit")
    public String editPostForm(@PathVariable("postId") Long postId, Model model){
        PostDTO postDTO = postService.findPostById(postId);
        model.addAttribute("editPostTemp",postDTO);
        return "admin/edit_post";
    }


    @PostMapping("/admin/posts/{postId}")
    public String updatePost(@PathVariable("postId") Long postId,
                             @Valid @ModelAttribute("editPostTemp") PostDTO postDTO,
                             BindingResult result,
                             Model model){
        if (result.hasErrors()){
            model.addAttribute("editPostTemp", postDTO);
            return "admin/edit_post";
        }
        postDTO.setId(postId);
        postService.updatePost(postDTO);
        return "redirect:/admin/posts";
    }

    @GetMapping("/admin/posts/{postId}/delete")
    public String deletePost(@PathVariable("postId") Long postId){
         postService.deletePost(postId);
         return "redirect:/admin/posts";
    }



    // handler method to handle view post request
    @GetMapping("/admin/posts/{postUrl}/view")
    public String viewPost(@PathVariable("postUrl") String postUrl, Model model){
        PostDTO postDto = postService.findPostByUrl(postUrl);
        model.addAttribute("post", postDto);
        return "admin/view_post";
    }

    // http://localhost:8080/admin/posts/search?word=java
    @GetMapping("/admin/posts/search")
    public String searchPost(@RequestParam(value ="word") String word, Model model){
      List<PostDTO> posts = postService.searchPosts(word);
      model.addAttribute("postsDtoList", posts);
        return "/admin/posts";
    }








    private static String getUrl(String postTitle){
        String title = postTitle.trim().toLowerCase();
        String url = title.replaceAll("\\s+","-");
        url = url.replaceAll("[^A-Za-z0-9]", "-");
        return url;
    }





}
