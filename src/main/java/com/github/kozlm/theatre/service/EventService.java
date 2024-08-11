package com.github.kozlm.theatre.service;

import com.github.kozlm.theatre.model.Hall;
import com.github.kozlm.theatre.model.event.Event;
import com.github.kozlm.theatre.model.event.EventDto;
import com.github.kozlm.theatre.model.play.Play;
import com.github.kozlm.theatre.repository.EventRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final HallService hallService;
    private final PlayService playService;

    @Autowired
    public EventService(
            EventRepository eventRepository,
            PlayService playService,
            HallService hallService
    ){
        this.eventRepository = eventRepository;
        this.playService = playService;
        this.hallService = hallService;
    }

    public Event getEventById(Long id){
        return eventRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Did not find event with id: " + id));
    }

    public List<Event> getEvents(){
        return eventRepository.findAll();
    }

    public void removeEventById(Long id){
        eventRepository.deleteById(id);
    }

    public void addEvent(EventDto dto){
        Hall hall = hallService.getHallById(dto.getHallId());
        Play play = playService.getPlayById(dto.getPlayId());

        Event event = Event.builder()
                .startDate(dto.getStartDate())
                .hall(hall)
                .play(play)
                .build();
        eventRepository.save(event);
    }

    @Transactional
    public void updateEvent(Long id, EventDto dto){
        Hall hall = hallService.getHallById(dto.getHallId());
        Play play = playService.getPlayById(dto.getPlayId());
        Event event = getEventById(id);

        event.setStartDate(dto.getStartDate());
        event.setHall(hall);
        event.setPlay(play);


        eventRepository.save(event);
    }
}
