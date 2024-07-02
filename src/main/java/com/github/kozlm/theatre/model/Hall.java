package com.github.kozlm.theatre.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hall_seq")
    @SequenceGenerator(name = "hall_seq", sequenceName = "HallSequence", allocationSize = 1)
    @Column(name = "HallId")
    private Long id;

    @NotBlank
    @Column(name = "Name", nullable = false, unique = true)
    private String name;

    @NotBlank
    @Positive
    @Column(name = "Capacity", nullable = false)
    private Long capacity;

}
