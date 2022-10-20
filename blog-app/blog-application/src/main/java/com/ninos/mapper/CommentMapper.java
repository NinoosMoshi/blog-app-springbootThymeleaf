package com.ninos.mapper;

import com.ninos.dto.CommentDTO;
import com.ninos.dto.PostDTO;
import com.ninos.entity.Comment;
import com.ninos.entity.Post;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class CommentMapper {

    @Autowired
    private static ModelMapper modelMapper;



    // map Comment entity to CommentDTO
    public static CommentDTO mapToCommentDTO(Comment comment){
        CommentDTO commentDTO = modelMapper.map(comment, CommentDTO.class);
        return commentDTO;
    }


    // map CommentDTO to Comment entity
    public static Comment mapToComment(CommentDTO commentDTO){
       Comment comment = modelMapper.map(commentDTO,Comment.class);
       return comment;
    }

}
