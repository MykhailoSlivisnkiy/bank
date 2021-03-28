package com.bank.application.controller;

import com.bank.application.dto.user.ClientDto;
import com.bank.application.dto.user.EmployeeDto;
import com.bank.application.model.User;
import com.bank.application.security.entity.UserToken;
import com.bank.application.security.filters.UsernameAndPasswordAuthenticationRequest;
import com.bank.application.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@CrossOrigin
public class UserController {
    private UserService userService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public UserToken login(@RequestBody UsernameAndPasswordAuthenticationRequest request) {
        return userService.login(request);
    }

    @GetMapping("/clients")
    @ResponseStatus(HttpStatus.OK)
    public List<ClientDto> findAllClients() {
        return userService.findAllClients();
    }

    @GetMapping("/employees")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeDto> findAllEmployees() {
        return userService.findAllEmployees();
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<User> findAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User findUser(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user) {
        userService.create(user);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@RequestBody User user) {
        userService.update(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
    }
}
