package com.github.kozlm.theatre.controller;

import com.github.kozlm.theatre.model.play.Play;
import com.github.kozlm.theatre.service.PlayService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/plays")
public class PlayController {
    private final PlayService playService;

    @Autowired
    public PlayController(PlayService playService){
        this.playService = playService;
    }

    @GetMapping
    public List<Play> getPlays(){
        return playService.getPlays();
    }

    @GetMapping(path = "/{id}")
    public Play getPlay(@PathVariable Long id){
        return playService.getPlayById(id);
    }

    @PostMapping
    public void createPlay(@RequestBody @Valid Play dto){
        playService.addPlay(dto);
    }

    @PutMapping(path = "/{id}")
    public void updatePlay(@RequestBody @Valid Play dto, @PathVariable Long id){
        playService.updatePlay(id, dto);
    }
}
