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

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "topic_id")
    private MainTopic mainTopic;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Role> roles;

}
