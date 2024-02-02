package com.bluefarid.raven.service;

import com.bluefarid.raven.domain.Client;
import com.bluefarid.raven.exception.ClientNotFoundException;
import com.bluefarid.raven.model.dto.ClientDTO;
import com.bluefarid.raven.model.mapper.ClientMapper;
import com.bluefarid.raven.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository repository;
    private final ClientMapper mapper = ClientMapper.INSTANCE;
    private final JwtService jwtService;

    public ClientDTO getClient(Long id) {
        return mapper.toDTO(repository.findById(id).orElseThrow(ClientNotFoundException::new));
    }

    public List<ClientDTO> getAll() {
        return mapper.toDTO(repository.findAll());
    }

    public List<ClientDTO> getContact(Long id) {
        return mapper.toDTO(repository.findById(id).orElseThrow(ClientNotFoundException::new).getContacts());
    }

    public ClientDTO addContact(Long id, Long contactId) {
        Client c = repository.findById(id).orElseThrow(ClientNotFoundException::new);
        c.getContacts().add(repository.findById(contactId).orElseThrow(ClientNotFoundException::new));
        return mapper.toDTO(repository.save(c));
    }

    public ClientDTO deleteContact(Long id, Long contactId) {
        Client c = repository.findById(id).orElseThrow(ClientNotFoundException::new);
        c.getContacts().removeIf(client -> client.getId().equals(contactId));
        return mapper.toDTO(repository.save(c));
    }

    public void deleteClient(Long id) {
        repository.deleteById(id);
    }

    public UserDetailsService userDetailsService() {
        return username -> repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("username not found!"));
    }


}
