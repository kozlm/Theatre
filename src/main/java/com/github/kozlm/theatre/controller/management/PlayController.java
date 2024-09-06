package com.github.kozlm.theatre.controller.management;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.kozlm.theatre.model.play.Play;
import com.github.kozlm.theatre.model.play.PlayDto;
import com.github.kozlm.theatre.service.PlayService;
import com.github.kozlm.theatre.validation.Views;
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
    @JsonView(Views.AdminView.class)
    public List<Play> getPlays() {
        return playService.getPlays();
    }

    @GetMapping(path = "/{id}")
    @JsonView(Views.AdminView.class)
    public Play getPlay(@PathVariable Long id) {
        return playService.getPlayById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPlay(@RequestBody @Valid PlayDto dto) {
        playService.addPlay(dto);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePlay(
            @RequestBody @Valid PlayDto dto,
            @PathVariable Long id
    ) {
        playService.updatePlay(id, dto);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlay(@PathVariable Long id) {
        playService.removePlayById(id);
    }
}
