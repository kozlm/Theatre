package com.github.kozlm.theatre.controller;

import com.github.kozlm.theatre.model.event.Event;
import com.github.kozlm.theatre.model.event.EventDto;
import com.github.kozlm.theatre.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/events")
public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService){
        this.eventService = eventService;
    }

    @GetMapping
    public List<Event> getEvents(){
        return eventService.getEvents();
    }

    @GetMapping(path = "/{id}")
    public Event getEvent(@PathVariable Long id){
        return eventService.getEventById(id);
    }

    @PostMapping
    public void createEvent(@RequestBody @Valid EventDto dto){
        eventService.addEvent(dto);
    }

    @PutMapping(path = "/{id}")
    public void updateEvent(@RequestBody @Valid EventDto dto, @PathVariable Long id){
        eventService.updateEvent(id, dto);
    }
}
