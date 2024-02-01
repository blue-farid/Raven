package com.bluefarid.raven.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    private Long id;
    private String firstname;
    private String lastname;
    @Column(unique = true)
    private String phone;
    @Column(unique = true)
    private String username;
    private String password;
    private String image;
    private String bio;
    @OneToMany(fetch = FetchType.LAZY)
    private List<User> contacts;

}
