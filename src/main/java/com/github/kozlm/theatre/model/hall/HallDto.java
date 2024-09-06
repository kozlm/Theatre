package com.github.kozlm.theatre.model.hall;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class HallDto {
    @NotBlank
    private String name;

    @NotNull
    @Positive
    private Long capacity;
}
