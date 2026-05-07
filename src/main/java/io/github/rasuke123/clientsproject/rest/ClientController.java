package io.github.rasuke123.clientsproject.rest;


import io.github.rasuke123.clientsproject.model.entity.Client;
import io.github.rasuke123.clientsproject.model.repository.ClientRepository;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;


    @PostMapping
    public Client Save(@RequestBody @Valid Client client) {
        return clientRepository.save(client);
    }

    @GetMapping
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @GetMapping("{id}")
    public Client findById(@PathVariable Integer id) {
        return clientRepository
                .findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        clientRepository.findById(id)
                .map( client ->  {
                    clientRepository.delete(client);
                    return Void.TYPE;
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        /// ^ verifica se existe na base de dados

        /// ou simplesmente clientRepository.deleteById(id);
    }

    @PutMapping
    public void Update(@PathVariable Integer id, @RequestBody @Valid Client clientupdated) {
        clientRepository.findById(id)
                .map( client ->  {
                    client.setName(clientupdated.getName());
                    client.setTIN(clientupdated.getTIN());
                    return clientRepository.save(clientupdated);
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }


}
