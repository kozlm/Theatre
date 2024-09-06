package com.github.kozlm.theatre.service;

import com.github.kozlm.theatre.model.event.Event;
import com.github.kozlm.theatre.model.play.Play;
import com.github.kozlm.theatre.model.play.PlayDto;
import com.github.kozlm.theatre.repository.PlayRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayService {
    private final PlayRepository playRepository;

    public Play getPlayById(Long id) {
        return playRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Did not find play with id: " + id));
    }

    public List<Play> getPlays() {
        return playRepository.findAll();
    }

    public List<Play> getCurrentPlays() {
        return playRepository.getCurrentPlays();
    }

    public void removePlayById(Long id) {
        Play play = getPlayById(id);
        playRepository.delete(play);
    }

    public void addPlay(PlayDto dto) {
        Play play = Play.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .duration(dto.getDuration())
                .classification(dto.getClassification())
                .build();
        playRepository.save(play);
    }

    @Transactional
    public void updatePlay(Long id, PlayDto dto) {
        Play play = getPlayById(id);

        play.setName(dto.getName());
        play.setDescription(dto.getDescription());
        play.setDuration(dto.getDuration());
        play.setClassification(dto.getClassification());

        playRepository.save(play);
    }
}
