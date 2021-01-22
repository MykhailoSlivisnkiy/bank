package com.bank.application.controller;

import com.bank.application.model.Client;
import com.bank.application.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class TestController {
    ClientService clientService;

    @GetMapping("/")
    public List<Client> test() {
        return clientService.readAll();
    }

    @PostMapping("/")
    public void save() {
        clientService.create(new Client("misha", "lastName", "login", "password", "miwka08006@gmail.com", "phone"));
    }
}
