package com.ninos.dto;

import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "The Title Should Not be Empty")
    private String title;
    @NotEmpty
    private String content;
    private String url;
    @NotEmpty
    private String description;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
