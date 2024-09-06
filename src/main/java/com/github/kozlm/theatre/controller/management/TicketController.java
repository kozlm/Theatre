package com.github.kozlm.theatre.controller.management;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.kozlm.theatre.model.ticket.Ticket;
import com.github.kozlm.theatre.model.ticket.TicketDto;
import com.github.kozlm.theatre.service.TicketService;
import com.github.kozlm.theatre.validation.Views;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/management/tickets")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;

    @GetMapping
    @JsonView(Views.AdminView.class)
    public List<Ticket> getTickets(){
        return ticketService.getTickets();
    }

    @GetMapping(path = "/{id}")
    @JsonView(Views.AdminView.class)
    public Ticket getTicket(@PathVariable Long id){
        return ticketService.getTicketById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTicket(@RequestBody @Valid TicketDto dto){
        ticketService.addTicket(dto);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTicket(@RequestBody @Valid TicketDto dto, @PathVariable Long id){
        ticketService.updateTicket(id, dto);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTicket(@PathVariable Long id){
        ticketService.removeTicketById(id);
    }
}
