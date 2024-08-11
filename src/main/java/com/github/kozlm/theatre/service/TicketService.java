package com.github.kozlm.theatre.service;

import com.github.kozlm.theatre.model.client.Client;
import com.github.kozlm.theatre.model.event.Event;
import com.github.kozlm.theatre.model.ticket.Ticket;
import com.github.kozlm.theatre.model.ticket.TicketDto;
import com.github.kozlm.theatre.repository.TicketRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private final EventService eventService;
    private final ClientService clientService;

    @Autowired
    public TicketService(
            TicketRepository ticketRepository,
            EventService eventService,
            ClientService clientService
    ){
        this.ticketRepository = ticketRepository;
        this.eventService = eventService;
        this.clientService = clientService;
    }

    public Ticket getTicketById(Long id){
        return ticketRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Did not find ticket with id: " + id));
    }

    public List<Ticket> getTickets(){
        return ticketRepository.findAll();
    }

    public void removeTicketById(Long id){
        ticketRepository.deleteById(id);
    }

    public void addTicket(TicketDto dto){
        Event event = eventService.getEventById(dto.getEventId());
        Client client = clientService.getClientById(dto.getClientId());

        Ticket ticket = Ticket.builder()
                .price(dto.getPrice())
                .place(dto.getPlace())
                .event(event)
                .client(client)
                .build();
        ticketRepository.save(ticket);
    }

    @Transactional
    public void updateTicket(Long id, TicketDto dto){
        Event event = eventService.getEventById(dto.getEventId());
        Client client = clientService.getClientById(dto.getClientId());
        Ticket ticket = getTicketById(id);

        ticket.setPrice(dto.getPrice());
        ticket.setPlace(dto.getPlace());
        ticket.setEvent(event);
        ticket.setClient(client);

        ticketRepository.save(ticket);
    }
}
