package com.bluefarid.raven.controller;

import com.bluefarid.raven.domain.Client;
import com.bluefarid.raven.domain.Message;
import com.bluefarid.raven.repository.ClientRepository;
import com.bluefarid.raven.repository.MessageRepository;
import com.bluefarid.raven.security.ClientUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class WebSocketController {
    private final SimpMessagingTemplate simpMessagingTemplate;
    private final MessageRepository messageRepository;
    private final ClientRepository clientRepository;

    @MessageMapping("/private-message")
    public Message recMessage(@Payload Message message) {
        simpMessagingTemplate.convertAndSendToUser(message.getText(), "/private", message);
        ClientUserDetails userDetails = (ClientUserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        message.setSender(new Client().setId(clientRepository.findByUsername(userDetails.getUsername()).orElseThrow().getId()));
        messageRepository.save(message);
        return message;
    }
}
