package com.github.kozlm.theatre.model.ticket;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class TicketDto {
    @NotBlank
    @Positive
    private BigDecimal price;

    @NotBlank
    @Positive
    private Long place;

    @NotBlank
    private Long eventId;

    @NotBlank
    private Long clientId;

}
