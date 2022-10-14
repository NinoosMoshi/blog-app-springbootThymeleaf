package com.ninos.service.impl;

import com.ninos.dto.PostDTO;
import com.ninos.entity.Post;
import com.ninos.mapper.PostMapper;
import com.ninos.repository.PostRepository;
import com.ninos.service.PostService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {


    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @Override
    public List<PostDTO> findAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map( post -> PostMapper.mapToPostDTO(post)).collect(Collectors.toList());
    }

    @Override
    public void createPost(PostDTO postDTO) {
        Post post = PostMapper.mapToPost(postDTO);
        postRepository.save(post);
    }

    @Override
    public PostDTO findPostById(Long postId) {
      Post post = postRepository.findById(postId).get();
        return PostMapper.mapToPostDTO(post);
    }

    @Override
    public void updatePost(PostDTO postDTO) {
        Post post = PostMapper.mapToPost(postDTO);
        postRepository.save(post);
    }

    @Override
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }


    @Override
    public PostDTO findPostByUrl(String postUrl) {
        Post post = postRepository.findByUrl(postUrl).get();
        return PostMapper.mapToPostDTO(post);
    }




}
