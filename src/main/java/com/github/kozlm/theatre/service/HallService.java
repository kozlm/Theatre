package com.github.kozlm.theatre.service;

import com.github.kozlm.theatre.model.hall.Hall;
import com.github.kozlm.theatre.model.hall.HallDto;
import com.github.kozlm.theatre.repository.HallRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HallService {
    private final HallRepository hallRepository;

    public Hall getHallById(Long id) {
        return hallRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Did not find hall with id: " + id));
    }

    public List<Hall> getHalls() {
        return hallRepository.findAll();
    }

    public void removeHallById(Long id) {
        Hall hall = getHallById(id);
        hallRepository.delete(hall);
    }

    public void addHall(HallDto dto) {
        Hall hall = Hall.builder()
                .name(dto.getName())
                .capacity(dto.getCapacity())
                .build();
        hallRepository.save(hall);
    }

    @Transactional
    public void updateHall(Long id, HallDto dto) {
        Hall hall = getHallById(id);

        hall.setName(dto.getName());
        hall.setCapacity(dto.getCapacity());

        hallRepository.save(hall);
    }
}
