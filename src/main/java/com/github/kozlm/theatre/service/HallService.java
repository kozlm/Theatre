package com.github.kozlm.theatre.service;

import com.github.kozlm.theatre.model.Hall;
import com.github.kozlm.theatre.model.event.Event;
import com.github.kozlm.theatre.repository.HallRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HallService {
    private final HallRepository hallRepository;

    @Autowired
    public HallService(HallRepository hallRepository){
        this.hallRepository = hallRepository;
    }

    public Hall getHallById(Long id){
        return hallRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Did not find hall with id: " + id));
    }

    public List<Hall> getHalls(){
        return hallRepository.findAll();
    }

    public void removeHallById(Long id){
        Hall hall = getHallById(id);
        hallRepository.delete(hall);
    }

    public void addHall(Hall dto){
        hallRepository.save(dto);
    }

    @Transactional
    public void updateHall(Long id, Hall dto){
        Hall hall = getHallById(id);

        hall.setName(dto.getName());
        hall.setCapacity(dto.getCapacity());

        hallRepository.save(hall);
    }
}
