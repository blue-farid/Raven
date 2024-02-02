package com.bluefarid.raven.controller;

import com.bluefarid.raven.model.dto.ChatDTO;
import com.bluefarid.raven.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/chat")
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;

    @GetMapping
    public ResponseEntity<List<ChatDTO>> getChats() {
        return ResponseEntity.ok(chatService.getChats());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatDTO> getChat(@PathVariable Long id) {
        return ResponseEntity.ok(chatService.getChat(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChat(@PathVariable Long id) {
        chatService.deleteChat(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}/message/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id, @PathVariable Long messageId) {
        chatService.deleteMessage(id, messageId);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<ChatDTO> createChat(@RequestBody ChatDTO chatDTO) {
        return ResponseEntity.ok(chatService.createChat(chatDTO));
    }
}
