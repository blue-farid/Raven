package com.bluefarid.raven.service;

import com.bluefarid.raven.domain.Client;
import com.bluefarid.raven.model.dto.ClientDTO;
import com.bluefarid.raven.model.request.LoginRequest;
import com.bluefarid.raven.model.response.LoginResponse;
import com.bluefarid.raven.model.response.SignupResponse;
import com.bluefarid.raven.repository.ClientRepository;
import com.bluefarid.raven.security.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public SignupResponse signup(ClientDTO request) {
        var user = Client.builder().username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ROLE_ADMIN).build();
        clientRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return new SignupResponse().setToken(jwt);
    }

    public LoginResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        var user = clientRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Invalid username or password"));
        var jwt = jwtService.generateToken(user);
        return new LoginResponse().setToken(jwt);
    }
}
