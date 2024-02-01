package com.bluefarid.raven.service;

import com.bluefarid.raven.exception.ClientNotFoundException;
import com.bluefarid.raven.model.dto.ClientDTO;
import com.bluefarid.raven.model.mapper.ClientMapper;
import com.bluefarid.raven.model.request.LoginRequest;
import com.bluefarid.raven.model.response.LoginResponse;
import com.bluefarid.raven.model.response.SignupResponse;
import com.bluefarid.raven.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository repository;
    private final ClientMapper mapper = ClientMapper.INSTANCE;

    public ClientDTO getClient(Long id) {
        return mapper.toDTO(repository.findById(id).orElseThrow(ClientNotFoundException::new));
    }

    public List<ClientDTO> getAll() {
        return mapper.toDTO(repository.findAll());
    }

    public List<ClientDTO> getContact(Long id) {
        return mapper.toDTO(repository.findById(id).orElseThrow(ClientNotFoundException::new).getContacts());
    }

    public SignupResponse signup(ClientDTO client) {
        return mapper.toSignupResponse(repository.save(mapper.toEntity(client)), null);
    }

    public LoginResponse login(LoginRequest request) {
        ClientDTO dto = mapper.toDTO(repository.findByUsername(request.getUsername())
                .orElseThrow(ClientNotFoundException::new));
        if (dto.getPassword().equals(request.getPassword())) {
            // TODO generate token
            return new LoginResponse().setClient(dto).setToken("token");
        } else {
            throw new BadCredentialsException("The Password is Incorrect!");
        }
    }


}
