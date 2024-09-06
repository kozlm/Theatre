package com.github.kozlm.theatre.model.ticket;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BuyTicketRequest {
    @NotNull
    @Positive
    private BigDecimal price;

    @NotNull
    @Positive
    private Long place;
}
