package com.app.service;

import com.app.dto.CommentDto;
import com.app.dto.MainTopicDto;
import com.app.dto.UserDto;
import com.app.model.Comment;
import com.app.model.MainTopic;
import com.app.model.User;

import java.util.HashSet;

public interface Mappers {

    static MainTopicDto fromMainTopicToMainTopicDto(MainTopic mainTopic){
        return mainTopic == null ? null : MainTopicDto.builder()
                .id(mainTopic.getId())
                .category(mainTopic.getCategory())
                .dateOfCreated(mainTopic.getDateOfCreated())
                .commentsDto(new HashSet<>())
                .build();
    }

    static MainTopic fromMainTopicDtoToMainTopic(MainTopicDto mainTopicDto){
        return mainTopicDto == null ? null : MainTopic.builder()
                .id(mainTopicDto.getId())
                .category(mainTopicDto.getCategory())
                .dateOfCreated(mainTopicDto.getDateOfCreated())
                .comments(new HashSet<>())
                .build();
    }

    static User fromUserDtoToUser(UserDto userDto){

        return userDto == null ? null : User.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .age(userDto.getAge())
                .email(userDto.getEmail())
                .roles(userDto.getRoles())
                .password(userDto.getPassword())
                .username(userDto.getUsername())
                .build();
    }

    static UserDto fromUserToUserDto(User user){
        return user == null ? null : UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .age(user.getAge())
                .email(user.getEmail())
                .roles(user.getRoles())
                .password(user.getPassword())
                .username(user.getUsername())
                .build();
    }

    static Comment fromCommentDtoToComment(CommentDto commentDto){
        return commentDto == null ? null : Comment.builder()
                .id(commentDto.getId())
                .dateOfCreated(commentDto.getDateOfCreated())
                .mainTopic(commentDto.getMainTopicDto() == null ? null : fromMainTopicDtoToMainTopic(commentDto.getMainTopicDto()))
                .message(commentDto.getMessage())
                .user(commentDto.getUserDto() == null ? null : fromUserDtoToUser(commentDto.getUserDto()))
                .build();
    }

    static CommentDto fromCommentToCommentDto(Comment comment){
        return comment == null ? null : CommentDto.builder()
                .id(comment.getId())
                .dateOfCreated(comment.getDateOfCreated())
                .mainTopicDto(comment.getMainTopic() == null ? null : fromMainTopicToMainTopicDto(comment.getMainTopic()))
                .message(comment.getMessage())
                .userDto(comment.getUser() == null ? null : fromUserToUserDto(comment.getUser()))
                .build();
    }


}
