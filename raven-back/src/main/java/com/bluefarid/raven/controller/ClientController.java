package com.bluefarid.raven.controller;

import com.bluefarid.raven.model.dto.ClientDTO;
import com.bluefarid.raven.model.request.CreateClientRequest;
import com.bluefarid.raven.model.request.UpdateClientRequest;
import com.bluefarid.raven.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClient(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getClient(id));
    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getClients() {
        return ResponseEntity.ok(clientService.getAll());
    }

    @GetMapping("/{id}/contacts")
    public ResponseEntity<List<ClientDTO>> getContacts(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getContact(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClientDTO> deleteClient(@PathVariable Long id) {
        return null;
    }
}
