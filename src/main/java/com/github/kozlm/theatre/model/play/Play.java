package com.github.kozlm.theatre.model.play;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.github.kozlm.theatre.model.event.Event;
import com.github.kozlm.theatre.validation.Views;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonView(Views.PlaysAdminView.class)
@Entity
public class Play {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "play_seq")
    @SequenceGenerator(name = "play_seq", sequenceName = "PlaySequence", allocationSize = 1)
    @Column(name = "PlayId")
    private Long id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "Duration", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "HH:mm:ss")
    private Time duration;

    @Column(name = "AgeClassification", nullable = false)
    @Enumerated(EnumType.STRING)
    private AgeClassification classification = AgeClassification.U;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "play",
            cascade = CascadeType.ALL
    )
    @JsonView(Views.PlaysGuestView.class)
    private List<Event> events;
}
