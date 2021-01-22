package com.bank.application.controller;

import com.bank.application.model.Client;
import com.bank.application.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {
    private ClientService clientService;

    @GetMapping("/{id}")
    public Client findClient(@PathVariable("id") Long id) {
        return clientService.findById(id);
    }

    @PostMapping()
    public List<Client> findAllClients(@RequestBody Client client) {
        return null;
    }

}
