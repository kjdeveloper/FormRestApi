package com.app.dto;

import com.app.model.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MainTopicDto {

    private Long id;
    private LocalDateTime dateOfCreated;
    private Category category;
    private UserDto userDto;
    private Set<CommentDto> commentsDto;
}
