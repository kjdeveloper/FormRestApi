package com.app.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String surname;
    private Integer age;

    private String email;
    private String username;
    private String password;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "user")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Comment> comments;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "user")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<MainTopic> mainTopics;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Role> roles;

}
