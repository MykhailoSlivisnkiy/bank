package com.bank.application.controller;

import com.bank.application.dto.user.ClientDto;
import com.bank.application.dto.user.EmployeeDto;
import com.bank.application.model.User;
import com.bank.application.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@CrossOrigin
public class UserController {
    private UserService userService;

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
