package com.bank.application.mapper.user;

import com.bank.application.dto.user.EmployeeDto;
import com.bank.application.mapper.Mapper;
import com.bank.application.model.User;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EmployeeResponseMapper implements Mapper<User, EmployeeDto> {
    private ModelMapper mapper;

    @Override
    public EmployeeDto convertToDto(User user) {
        return mapper.map(user, EmployeeDto.class);
    }

    @Override
    public User convertToEntity(EmployeeDto employeeDto) {
        return mapper.map(employeeDto, User.class);
    }
}
