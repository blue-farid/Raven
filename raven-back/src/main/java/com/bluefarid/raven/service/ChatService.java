package com.bluefarid.raven.service;

import com.bluefarid.raven.domain.Chat;
import com.bluefarid.raven.model.dto.ChatDTO;
import com.bluefarid.raven.model.mapper.ChatMapper;
import com.bluefarid.raven.repository.ChatRepository;
import com.bluefarid.raven.security.ClientUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;
    private final ChatMapper chatMapper = ChatMapper.INSTANCE;

    public ChatDTO createChat(ChatDTO chatDTO) {
        return chatMapper.toDTO(chatRepository.save(chatMapper.toEntity(chatDTO)));
    }

    public List<ChatDTO> getChats() {
        ClientUserDetails userDetails = (ClientUserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        return chatMapper.toDTO(chatRepository.findAll().stream().filter(
                ch -> ch.getClients().stream().anyMatch(c -> c.getUsername().equals(userDetails.getUsername()))
        ).collect(Collectors.toList()));
    }

    public ChatDTO getChat(Long id) {
        ClientUserDetails userDetails = (ClientUserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        List<ChatDTO> chats = chatMapper.toDTO(chatRepository.findAll().stream().filter(
                ch -> ch.getClients().stream().anyMatch(c -> c.getUsername().equals(userDetails.getUsername()))
        ).collect(Collectors.toList()));

        return chats.stream().filter(c -> c.getId().equals(id)).findFirst().orElseThrow();
    }

    public void deleteChat(Long id) {
        chatRepository.deleteById(id);
    }

    public ChatDTO deleteMessage(Long id, Long messageId) {
        ClientUserDetails userDetails = (ClientUserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        List<ChatDTO> chats = chatMapper.toDTO(chatRepository.findAll().stream().filter(
                ch -> ch.getClients().stream().anyMatch(c -> c.getUsername().equals(userDetails.getUsername()))
        ).collect(Collectors.toList()));

        ChatDTO chatDTO = chats.stream().filter(c -> c.getId().equals(id)).findFirst().orElseThrow();
        chatDTO.getMessages().removeIf(m -> m.getId().equals(messageId));
        return chatMapper.toDTO(chatRepository.save(chatMapper.toEntity(chatDTO)));
    }
}
