package com.ninos.service;

import com.ninos.dto.PostDTO;
import com.ninos.entity.Post;

import java.util.List;

public interface PostService {

    List<PostDTO> findAllPosts();
    void createPost(PostDTO postDTO);
    PostDTO findPostById(Long postId);
    void updatePost(PostDTO postDTO);
    void deletePost(Long postId);
    PostDTO findPostByUrl(String postUrl);
}
