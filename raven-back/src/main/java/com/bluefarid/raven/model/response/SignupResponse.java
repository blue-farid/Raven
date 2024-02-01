package com.bluefarid.raven.model.response;

import com.bluefarid.raven.model.dto.ClientDTO;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SignupResponse {
    private ClientDTO client;
    private String token;
}
