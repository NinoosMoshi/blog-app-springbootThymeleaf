package com.ninos.service;

import com.ninos.dto.PostDTO;

import java.util.List;

public interface PostService {

    List<PostDTO> findAllPosts();

}
