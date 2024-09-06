package com.github.kozlm.theatre.controller;

import com.github.kozlm.theatre.model.client.Client;
import com.github.kozlm.theatre.model.client.ClientDto;
import com.github.kozlm.theatre.model.ticket.BuyTicketRequest;
import com.github.kozlm.theatre.model.ticket.Ticket;
import com.github.kozlm.theatre.service.ClientService;
import com.github.kozlm.theatre.service.TicketService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/")
@RequiredArgsConstructor
@PreAuthorize("hasRole('CLIENT')")
public class UserController {
    private final TicketService ticketService;
    private final ClientService clientService;

    @GetMapping(path = "/my-tickets")
    public List<Ticket> getMyTickets
            (@AuthenticationPrincipal UserDetails userDetails) {
        return clientService.getMyTickets(userDetails);
    }

    @PostMapping(path = "/current-events/{eventId}/buy-ticket")
    @ResponseStatus(HttpStatus.OK)
    public void buyTicket(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable Long eventId,
            @RequestBody @Valid BuyTicketRequest dto
    ) {
        ticketService.buyTicket(userDetails, eventId, dto);
    }

    @DeleteMapping(path = "/my-tickets/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void withdrawTicket(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable Long id
    ) {
        ticketService.withdrawTicketById(userDetails, id);
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
}
