package com.github.kozlm.theatre.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.kozlm.theatre.model.event.Event;
import com.github.kozlm.theatre.model.play.Play;
import com.github.kozlm.theatre.service.EventService;
import com.github.kozlm.theatre.service.PlayService;
import com.github.kozlm.theatre.validation.Views;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/v1")
@RequiredArgsConstructor
public class GuestController {
    private final PlayService playService;

    @GetMapping(path = "/current-plays")
    @JsonView(Views.AdminView.class)
    public List<Play> getCurrentPlays(){
        return playService.getCurrentPlays();
    }

    @GetMapping(path = "/current-events")
    @JsonView(Views.GuestView.class)
    public List<Play> getCurrentPlaysWithEvents(){
        return playService.getCurrentPlays();
    }
}
