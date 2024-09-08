package com.github.kozlm.theatre.model.ticket;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.kozlm.theatre.model.event.Event;
import com.github.kozlm.theatre.validation.Views;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@JsonView(Views.AdminView.class)
public class MyTicketDto {
    private BigDecimal price;

    private Long place;

    private Event event;
}
