package com.github.kozlm.theatre.model.ticket;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.kozlm.theatre.model.event.Event;
import com.github.kozlm.theatre.model.client.Client;
import com.github.kozlm.theatre.validation.Views;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonView(Views.AdminView.class)
@Builder
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_seq")
    @SequenceGenerator(name = "ticket_seq", sequenceName = "TicketSequence", allocationSize = 1)
    @Column(name = "TicketId")
    private Long id;

    @Column(name = "Price", nullable = false)
    private BigDecimal price;

    @Column(name = "Place", nullable = false)
    private Long place;

    @ManyToOne
    @JoinColumn(name = "EventId", referencedColumnName = "EventId", nullable = false)
    private Event event;

    @ManyToOne
    @JoinColumn(name = "ClientId", referencedColumnName = "ClientId", nullable = false)
    private Client client;

}
