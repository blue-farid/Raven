package com.bluefarid.raven.service;

import com.bluefarid.raven.exception.ClientNotFoundException;
import com.bluefarid.raven.model.dto.ClientDTO;
import com.bluefarid.raven.model.mapper.ClientMapper;
import com.bluefarid.raven.model.request.CreateClientRequest;
import com.bluefarid.raven.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository repository;
    private final ClientMapper mapper;

    public ClientDTO getClient(Long id) {
        return mapper.toDTO(repository.findById(id).orElseThrow(ClientNotFoundException::new));
    }

    public List<ClientDTO> getAll() {
        return mapper.toDTO(repository.findAll());
    }
}
