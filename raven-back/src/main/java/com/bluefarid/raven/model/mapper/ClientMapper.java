package com.bluefarid.raven.model.mapper;

import com.bluefarid.raven.domain.Client;
import com.bluefarid.raven.model.dto.ClientDTO;
import com.bluefarid.raven.model.response.SignupResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientDTO toDTO(Client client);
    List<ClientDTO> toDTO(List<Client> client);
    Client toEntity(ClientDTO dto);
    List<Client> toEntity(List<ClientDTO> dto);
    default SignupResponse toSignupResponse(Client client, String token) {
        ClientDTO dto = toDTO(client);
        return new SignupResponse().setClient(dto).setToken(token);
    }
}
