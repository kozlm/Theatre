package com.github.kozlm.theatre.model.hall;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.kozlm.theatre.validation.Views;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonView(Views.DefaultView.class)
@Entity
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hall_seq")
    @SequenceGenerator(name = "hall_seq", sequenceName = "HallSequence", allocationSize = 1)
    @Column(name = "HallId")
    private Long id;

    @Column(name = "Name", nullable = false, unique = true)
    private String name;

    @Column(name = "Capacity", nullable = false)
    private Long capacity;
}
