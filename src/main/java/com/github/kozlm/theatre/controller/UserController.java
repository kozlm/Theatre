package com.github.kozlm.theatre.controller;

import com.github.kozlm.theatre.model.client.Client;
import com.github.kozlm.theatre.model.client.ClientDto;
import com.github.kozlm.theatre.model.ticket.Ticket;
import com.github.kozlm.theatre.service.ClientService;
import com.github.kozlm.theatre.service.TicketService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
@RequiredArgsConstructor
public class UserController {
    private final TicketService ticketService;
    private final ClientService clientService;

    @GetMapping(path = "/my-tickets")
    public List<Ticket> getMyTickets
            (@AuthenticationPrincipal UserDetails userDetails) {
        return clientService.getMyTickets(userDetails);
    }

    @GetMapping(path = "/my-account")
    public Client getMyInformation
            (@AuthenticationPrincipal UserDetails userDetails) {
        return clientService.getMyInformation(userDetails);
    }

    @PutMapping(path = "/my-account")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateMyInformation(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestBody @Valid ClientDto dto
    ) {
        clientService.updateMyInformation(userDetails, dto);
    }

    // todo buy, withdraw ticket
}
