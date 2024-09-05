package com.github.kozlm.theatre.controller.management;

import com.github.kozlm.theatre.model.client.Client;
import com.github.kozlm.theatre.model.client.ClientDto;
import com.github.kozlm.theatre.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/management/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping
    public List<Client> getClients(){
        return clientService.getClients();
    }

    @GetMapping(path = "/{id}")
    public Client getClient(@PathVariable Long id){
        return clientService.getClientById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createClient(@RequestBody @Valid ClientDto dto){
        clientService.addClient(dto);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateClient(@RequestBody @Valid ClientDto dto, @PathVariable Long id){
        clientService.updateClient(id, dto);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable Long id){
        clientService.removeClientById(id);
    }
}
