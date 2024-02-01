package com.bluefarid.raven.model.dto;

import com.bluefarid.raven.domain.User;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String phone;
    private String username;
    private String password;
    private String image;
    private String bio;
    private List<User> contacts;
}
