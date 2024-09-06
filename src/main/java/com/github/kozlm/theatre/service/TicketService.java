package com.github.kozlm.theatre.service;

import com.github.kozlm.theatre.model.client.Client;
import com.github.kozlm.theatre.model.event.Event;
import com.github.kozlm.theatre.model.ticket.BuyTicketRequest;
import com.github.kozlm.theatre.model.ticket.Ticket;
import com.github.kozlm.theatre.model.ticket.TicketDto;
import com.github.kozlm.theatre.repository.TicketRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;
    private final EventService eventService;
    private final ClientService clientService;

    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Did not find ticket with id: " + id));
    }

    public List<Ticket> getTickets() {
        return ticketRepository.findAll();
    }

    public void withdrawTicketById(UserDetails userDetails, Long id) {
        Long clientId = ((Client) userDetails).getId();
        Ticket ticket = getTicketById(id);
        if (ticket.getClient().getId().equals(clientId)) ticketRepository.delete(ticket);
        else throw new IllegalArgumentException("Cannot withdraw ticket with id: " + id);
    }

    public void removeTicketById(Long id) {
        Ticket ticket = getTicketById(id);
        ticketRepository.delete(ticket);
    }

    public void addTicket(TicketDto dto) {
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

    public void buyTicket(UserDetails userDetails, Long eventId, BuyTicketRequest dto) {
        Event event = eventService.getCurrentEventById(eventId);
        Client client = clientService.getClientById(((Client) userDetails).getId());

        Ticket ticket = Ticket.builder()
                .price(dto.getPrice())
                .place(dto.getPlace())
                .event(event)
                .client(client)
                .build();
        ticketRepository.save(ticket);
    }

    @Transactional
    public void updateTicket(Long id, TicketDto dto) {
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
