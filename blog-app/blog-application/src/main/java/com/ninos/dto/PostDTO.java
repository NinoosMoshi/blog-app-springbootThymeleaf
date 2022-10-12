package com.ninos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PostDTO {

    private Long id;
    private String title;
    private String content;
    private String url;
    private String description;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
