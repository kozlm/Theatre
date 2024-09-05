package com.github.kozlm.theatre.controller.management;

import com.github.kozlm.theatre.model.play.Play;
import com.github.kozlm.theatre.service.PlayService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/management/plays")
@RequiredArgsConstructor
public class PlayController {
    private final PlayService playService;

    @GetMapping
    public List<Play> getPlays(){
        return playService.getPlays();
    }

    @GetMapping(path = "/{id}")
    public Play getPlay(@PathVariable Long id){
        return playService.getPlayById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPlay(@RequestBody @Valid Play dto){
        playService.addPlay(dto);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePlay(@RequestBody @Valid Play dto, @PathVariable Long id){
        playService.updatePlay(id, dto);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlay(@PathVariable Long id){
        playService.removePlayById(id);
    }
}
