package com.bluefarid.raven.controller;

import com.bluefarid.raven.model.dto.ClientDTO;
import com.bluefarid.raven.model.request.LoginRequest;
import com.bluefarid.raven.model.response.LoginResponse;
import com.bluefarid.raven.model.response.SignupResponse;
import com.bluefarid.raven.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for authentication-related endpoints.
 * This class handles the authentication requests such as login.
 * It maps the endpoints to appropriate request handling methods.
 *
 * @author Farid Masjedi
 */
@RestController
@RequestMapping( "/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    /**
     * Handles the login request.
     * This method receives a POST request to the "/login" endpoint and authenticates the user.
     * It delegates the authentication process to the AuthenticationService and returns the JWT authentication response
     * in the response body.
     *
     * @param request The SignInRequest object containing the user's credentials.
     * @return ResponseEntity containing the BaseResponseDto with the JWT authentication response.
     */
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authenticationService.login(request));
    }

    @PostMapping("/signup")
    public ResponseEntity<SignupResponse> signup(@RequestBody ClientDTO request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }
}
