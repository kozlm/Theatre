package com.github.kozlm.theatre.repository;

import com.github.kozlm.theatre.model.client.Client;
import com.github.kozlm.theatre.model.ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByClient(Client client);
}
