package com.github.kozlm.theatre.controller.management;

import com.github.kozlm.theatre.model.Hall;
import com.github.kozlm.theatre.service.HallService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/management/halls")
@RequiredArgsConstructor
public class HallController {
    private final HallService hallService;

    @GetMapping
    public List<Hall> getHalls(){
        return hallService.getHalls();
    }

    @GetMapping(path = "/{id}")
    public Hall getHall(@PathVariable Long id){
        return hallService.getHallById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createHall(@RequestBody @Valid Hall dto){
        hallService.addHall(dto);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateHall(@RequestBody @Valid Hall dto, @PathVariable Long id){
        hallService.updateHall(id, dto);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHall(@PathVariable Long id){
        hallService.removeHallById(id);
    }
}
