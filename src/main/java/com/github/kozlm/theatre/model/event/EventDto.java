package com.github.kozlm.theatre.model.event;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.util.Date;

@Data
public class EventDto {
    @NotBlank
    @Future
    private Date startDate;

    private Long hallId;

    @NotBlank
    private Long playId;
}
