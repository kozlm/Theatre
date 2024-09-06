package com.github.kozlm.theatre.service;

import com.github.kozlm.theatre.model.hall.Hall;
import com.github.kozlm.theatre.model.event.Event;
import com.github.kozlm.theatre.model.event.EventDto;
import com.github.kozlm.theatre.model.play.Play;
import com.github.kozlm.theatre.repository.EventRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final HallService hallService;
    private final PlayService playService;

    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Did not find event with id: " + id));
    }

    public Event getCurrentEventById(Long id) {
        Event event = getEventById(id);
        if (event.getStartDate().before(new Date()))
            throw new IllegalArgumentException("No current event with id: " + id);
        else return event;
    }

    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    public void removeEventById(Long id) {
        Event event = getEventById(id);
        eventRepository.delete(event);
    }

    public void addEvent(EventDto dto) {
        Hall hall = dto.getHallId() == null ?
                null : hallService.getHallById(dto.getHallId());
        Play play = playService.getPlayById(dto.getPlayId());

        Event event = Event.builder()
                .startDate(dto.getStartDate())
                .hall(hall)
                .play(play)
                .build();
        eventRepository.save(event);
    }

    @Transactional
    public void updateEvent(Long id, EventDto dto) {
        Hall hall = hallService.getHallById(dto.getHallId());
        Play play = playService.getPlayById(dto.getPlayId());
        Event event = getEventById(id);

        event.setStartDate(dto.getStartDate());
        event.setHall(hall);
        event.setPlay(play);


        eventRepository.save(event);
    }
}
