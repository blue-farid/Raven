package com.bluefarid.raven.model.request;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
public class LoginRequest {
    private String token;
    private String username;
    private String password;
}
