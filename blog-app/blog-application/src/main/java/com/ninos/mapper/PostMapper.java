package com.ninos.mapper;

import com.ninos.dto.PostDTO;
import com.ninos.entity.Post;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class PostMapper {

    @Autowired
    private ModelMapper modelMapper;



    // map Post entity to PostDTO
    public static PostDTO mapToPostDTO(Post post){
//        PostDTO postDTO = modelMapper.map(post, PostDTO.class);    // modelMapper
//        return postDTO;

//        PostDTO postDTO = new PostDTO();                           // set
//        postDTO.setId(post.getId());
//        postDTO.setTitle(post.getTitle());
//        return postDTO;

        PostDTO postDTO = PostDTO.builder()                        // builder
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .url(post.getUrl())
                .description(post.getDescription())
                .createdOn(post.getCreatedOn())
                .updatedOn(post.getUpdatedOn())
                .build();
        return postDTO;

    }


    // map PostDTO to Post entity
    public static Post mapToPost(PostDTO postDTO){
        Post post = Post.builder()
                .id(postDTO.getId())
                .title(postDTO.getTitle())
                .content(postDTO.getContent())
                .url(postDTO.getUrl())
                .description(postDTO.getDescription())
                .createdOn(postDTO.getCreatedOn())
                .updatedOn(postDTO.getUpdatedOn())
                .build();
        return post;
    }

}
