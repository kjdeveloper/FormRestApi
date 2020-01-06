package com.app.dto;

import com.app.model.MainTopic;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDto {

    private Long id;
    private String message;
    private LocalDateTime dateOfCreated;
    private UserDto userDto;
    private MainTopicDto mainTopicDto;
}
