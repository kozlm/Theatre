package com.github.kozlm.theatre.model.play;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Time;

@Data
public class PlayDto {
    @NotBlank
    private String name;

    private String description;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "HH:mm:ss")
    private Time duration;

    @NotNull
    private AgeClassification classification = AgeClassification.U;
}
