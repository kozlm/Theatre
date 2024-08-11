package com.github.kozlm.theatre.controller;

import com.github.kozlm.theatre.model.client.Client;
import com.github.kozlm.theatre.model.client.ClientDto;
import com.github.kozlm.theatre.service.ClientService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Negative;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/clients")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getClients(){
        return clientService.getClients();
    }

    @GetMapping(path = "/{id}")
    public Client getClient(@PathVariable Long id){
        return clientService.getClientById(id);
    }

    @PostMapping
    public void createClient(@RequestBody @Valid ClientDto dto){
        clientService.addClient(dto);
    }

    @PutMapping(path = "/{id}")
    public void updateClient(@RequestBody @Valid ClientDto dto, @PathVariable Long id){
        clientService.updateClient(id, dto);
    }
}
