package com.github.kozlm.theatre.model.event;

import com.github.kozlm.theatre.model.Hall;
import com.github.kozlm.theatre.model.play.Play;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_seq")
    @SequenceGenerator(name = "event_seq", sequenceName = "EventSequence", allocationSize = 1)
    @Column(name = "EventId")
    private Long id;

    @Column(name = "StartDate")
    private Date startDate;

    @ManyToOne
    @JoinColumn(name = "HallId", referencedColumnName = "HallId")
    private Hall hall;

    @ManyToOne
    @JoinColumn(name = "PlayId", referencedColumnName = "PlayId", nullable = false)
    private Play play;
}
