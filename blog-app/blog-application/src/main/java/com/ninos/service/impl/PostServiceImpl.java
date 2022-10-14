package com.ninos.service.impl;

import com.ninos.dto.PostDTO;
import com.ninos.entity.Post;
import com.ninos.mapper.PostMapper;
import com.ninos.repository.PostRepository;
import com.ninos.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
