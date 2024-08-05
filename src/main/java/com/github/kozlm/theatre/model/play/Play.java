package com.github.kozlm.theatre.model.play;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@NoArgsConstructor
@Entity
public class Play {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "play_seq")
    @SequenceGenerator(name = "play_seq", sequenceName = "PlaySequence", allocationSize = 1)
    @Column(name = "PlayId")
    private Long id;

    @NotBlank
    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Description")
    private String description;

    @NotBlank
    @Column(name = "Duration", nullable = false)
    private Time duration;

    @Column(name = "AgeClassification", nullable = false)
    @Enumerated(EnumType.STRING)
    private AgeClassification classification = AgeClassification.U;
}
