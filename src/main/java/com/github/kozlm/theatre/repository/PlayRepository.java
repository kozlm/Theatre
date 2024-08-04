package com.github.kozlm.theatre.repository;

import com.github.kozlm.theatre.model.Play;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayRepository extends JpaRepository<Play, Long> {

}
