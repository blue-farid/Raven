package com.bluefarid.raven.controller;

import com.bluefarid.raven.model.dto.ClientDTO;
import com.bluefarid.raven.model.request.LoginRequest;
import com.bluefarid.raven.model.response.LoginResponse;
import com.bluefarid.raven.model.response.SignupResponse;
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

    @PatchMapping("/{id}/contact/{contactId}")
    public ResponseEntity<ClientDTO> addContact(@PathVariable Long id, @PathVariable Long contactId) {
        return ResponseEntity.ok(clientService.addContact(id, contactId));
    }

    @DeleteMapping("/{id}/contact/{contactId}")
    public ResponseEntity<ClientDTO> deleteContact(@PathVariable Long id, @PathVariable Long contactId) {
        return ResponseEntity.ok(clientService.deleteContact(id, contactId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.ok().build();
    }
}
