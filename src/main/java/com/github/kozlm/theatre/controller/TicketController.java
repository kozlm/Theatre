package com.github.kozlm.theatre.controller;

import com.github.kozlm.theatre.model.play.Play;
import com.github.kozlm.theatre.model.ticket.Ticket;
import com.github.kozlm.theatre.model.ticket.TicketDto;
import com.github.kozlm.theatre.service.PlayService;
import com.github.kozlm.theatre.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/tickets")
public class TicketController {
    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    @GetMapping
    public List<Ticket> getTickets(){
        return ticketService.getTickets();
    }

    @GetMapping(path = "/{id}")
    public Ticket getTicket(@PathVariable Long id){
        return ticketService.getTicketById(id);
    }

    @PostMapping
    public void createTicket(@RequestBody @Valid TicketDto dto){
        ticketService.addTicket(dto);
    }

    @PutMapping(path = "/{id}")
    public void updateTicket(@RequestBody @Valid TicketDto dto, @PathVariable Long id){
        ticketService.updateTicket(id, dto);
    }
}
