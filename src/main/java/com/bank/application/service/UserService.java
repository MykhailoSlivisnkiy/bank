package com.bank.application.service;

import com.bank.application.Application;
import com.bank.application.constant.ErrorMessages;
import com.bank.application.dto.user.ClientDto;
import com.bank.application.dto.user.EmployeeDto;
import com.bank.application.exception.NotFoundIdException;
import com.bank.application.mapper.user.ClientResponseMapper;
import com.bank.application.mapper.user.EmployeeResponseMapper;
import com.bank.application.model.User;
import com.bank.application.model.enums.Role;
import com.bank.application.repository.UserRepository;
import com.bank.application.security.entity.ApplicationUser;
import com.bank.application.security.entity.UserToken;
import com.bank.application.security.filters.UsernameAndPasswordAuthenticationRequest;
import com.bank.application.security.jwt.JwtTokenProvider;
import com.bank.application.security.service.ApplicationUserService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private ClientResponseMapper clientMapper;
    private EmployeeResponseMapper employeeMapper;
    private JwtTokenProvider tokenProvider;

    public UserToken login(UsernameAndPasswordAuthenticationRequest request) {
        Authentication auth = new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword());

        SecurityContextHolder.getContext().setAuthentication(auth);
        User user = userRepository.findAllByUsername(request.getUsername())
                .orElseThrow(() -> new NotFoundIdException(String.format(ErrorMessages.USER_WAS_NOT_FOUND_BY_ID, request.getUsername())));
        return new UserToken(tokenProvider.generateAccessToken(auth));
    }

    public void create(User user) {
        userRepository.save(user);
    }

    public List<ClientDto> findAllClients() {
        return userRepository.findAllByRoles(Role.ROLE_CLIENT).stream()
                .map(user -> clientMapper.convertToDto(user))
                .collect(Collectors.toList());
    }

    public List<EmployeeDto> findAllEmployees() {
        return userRepository.findAllByRoles(Role.ROLE_EMPLOYEE).stream()
                .map(user -> employeeMapper.convertToDto(user))
                .collect(Collectors.toList());
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new NotFoundIdException(String.format(ErrorMessages.USER_WAS_NOT_FOUND_BY_ID, id))
        );
    }

    public boolean update(User user) {
        if (userRepository.existsById(user.getId())) {
            userRepository.save(user);
            return true;
        }

        return false;
    }

    public boolean delete(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
