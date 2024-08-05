package com.github.kozlm.theatre.model;

import com.github.kozlm.theatre.model.client.Client;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_seq")
    @SequenceGenerator(name = "ticket_seq", sequenceName = "TicketSequence", allocationSize = 1)
    @Column(name = "TicketId")
    private Long id;

    @NotBlank
    @Positive
    @Column(name = "Price", nullable = false)
    private BigDecimal price;

    @NotBlank
    @Positive
    @Column(name = "Place", nullable = false)
    private Long place;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "EventId", referencedColumnName = "EventId", nullable = false)
    private Event event;

    @ManyToOne
    @JoinColumn(name = "ClientId", referencedColumnName = "ClientId", nullable = false)
    private Client client;

}
