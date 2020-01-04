package com.app.model;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Forum {

    private Set<User> users = new HashSet<>();

}
