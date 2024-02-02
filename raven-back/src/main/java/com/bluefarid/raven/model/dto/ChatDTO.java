package com.bluefarid.raven.model.dto;

import com.bluefarid.raven.domain.Client;
import com.bluefarid.raven.domain.Message;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class ChatDTO {
    private Long id;
    private List<ClientDTO> clients;
    private List<Message> messages;
}
