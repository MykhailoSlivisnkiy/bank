package com.bank.application.service;

import com.bank.application.constant.ErrorMessages;
import com.bank.application.exception.NotFoundIdException;
import com.bank.application.model.Client;
import com.bank.application.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {
    private ClientRepository clientRepository;

    public void create(Client client) {
        clientRepository.save(client);
    }

    public List<Client> readAll() {
        return clientRepository.findAll();
    }

    public Client findById(Long id) {
        return clientRepository.findById(id).orElseThrow(
                () -> new NotFoundIdException(String.format(ErrorMessages.CLIENT_WAS_NOT_FOUND_BY_ID, id))
        );
    }

    public boolean update(Client client, Long id) {
        if (clientRepository.existsById(id)) {
            client.setId(id);
            clientRepository.save(client);
            return true;
        }

        return false;
    }

    public boolean delete(Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }
}