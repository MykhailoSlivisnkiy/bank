package com.bank.application.controller;

import com.bank.application.dto.user.ClientDto;
import com.bank.application.dto.user.EmployeeDto;
import com.bank.application.model.User;
import com.bank.application.security.entity.UserToken;
import com.bank.application.security.filters.UsernameAndPasswordAuthenticationRequest;
import com.bank.application.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@CrossOrigin
public class UserController {
    private UserService userService;

    @PostMapping("/login")
    public UserToken login(@RequestBody UsernameAndPasswordAuthenticationRequest request) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword());
        return userService.login(request);
    }

    @GetMapping("/clients")
    public List<ClientDto> findAllClients() {
        return userService.findAllClients();
    }

    @GetMapping("/employees")
    public List<EmployeeDto> findAllEmployees() {
        return userService.findAllEmployees();
    }

    @GetMapping()
    public List<User> findAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findUser(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PostMapping()
    public void createUser(@RequestBody User user) {
        userService.create(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
    }
}
