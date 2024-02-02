package com.bluefarid.raven.model.mapper;

import com.bluefarid.raven.domain.Chat;
import com.bluefarid.raven.model.dto.ChatDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ChatMapper {
    ChatMapper INSTANCE = Mappers.getMapper(ChatMapper.class);

    ChatDTO toDTO(Chat client);

    List<ChatDTO> toDTO(List<Chat> client);

    Chat toEntity(ChatDTO dto);

    List<Chat> toEntity(List<ChatDTO> dto);
}
