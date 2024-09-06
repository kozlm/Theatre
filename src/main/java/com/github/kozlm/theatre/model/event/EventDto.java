package com.github.kozlm.theatre.model.event;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.Date;

@Data
public class EventDto {
    @NotNull
    @Future
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "dd-MM-yyyy HH:mm")
    private Date startDate;

    private Long hallId;

    @NotNull
    private Long playId;
}
