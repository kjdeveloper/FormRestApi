package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private String username;
    private String email;
    private String password;
    private String passwordConfirmation;
    private Set<String> role;

}
