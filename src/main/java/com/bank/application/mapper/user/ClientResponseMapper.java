package com.bank.application.mapper.user;

import com.bank.application.dto.user.ClientDto;
import com.bank.application.mapper.Mapper;
import com.bank.application.model.User;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ClientResponseMapper implements Mapper<User, ClientDto> {
    private ModelMapper mapper;

    @Override
    public ClientDto convertToDto(User user) {
        return mapper.map(user, ClientDto.class);
    }

    @Override
    public User convertToEntity(ClientDto clientDto) {
        return mapper.map(clientDto, User.class);
    }
}
