package com.github.kozlm.theatre.controller;

import com.github.kozlm.theatre.model.Hall;
import com.github.kozlm.theatre.service.HallService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/halls")
public class HallController {
    private final HallService hallService;

    @Autowired
    public HallController(HallService hallService){
        this.hallService = hallService;
    }

    @GetMapping
    public List<Hall> getHalls(){
        return hallService.getHalls();
    }

    @GetMapping(path = "/{id}")
    public Hall getHall(@PathVariable Long id){
        return hallService.getHallById(id);
    }

    @PostMapping
    public void createHall(@RequestBody @Valid Hall dto){
        hallService.addHall(dto);
    }

    @PutMapping(path = "/{id}")
    public void updateHall(@RequestBody @Valid Hall dto, @PathVariable Long id){
        hallService.updateHall(id, dto);
    }
}
