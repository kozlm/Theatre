package com.github.kozlm.theatre.repository;

import com.github.kozlm.theatre.model.play.Play;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayRepository extends JpaRepository<Play, Long> {
    @Query(value = """
    SELECT DISTINCT p FROM Play p
    JOIN p.events e
    WHERE e.startDate > CURRENT_TIMESTAMP
    """)
    List<Play> getCurrentPlays();
}
