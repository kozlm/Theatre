package com.github.kozlm.theatre.controller.management;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.kozlm.theatre.model.event.Event;
import com.github.kozlm.theatre.model.event.EventDto;
import com.github.kozlm.theatre.service.EventService;
import com.github.kozlm.theatre.validation.Views;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/management/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @GetMapping
    @JsonView(Views.AdminView.class)
    public List<Event> getEvents(){
        return eventService.getEvents();
    }

    @GetMapping(path = "/{id}")
    @JsonView(Views.AdminView.class)
    public Event getEvent(@PathVariable Long id){
        return eventService.getEventById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createEvent(@RequestBody @Valid EventDto dto){
        eventService.addEvent(dto);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEvent(@RequestBody @Valid EventDto dto, @PathVariable Long id){
        eventService.updateEvent(id, dto);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEvent(@PathVariable Long id){
        eventService.removeEventById(id);
    }
}
