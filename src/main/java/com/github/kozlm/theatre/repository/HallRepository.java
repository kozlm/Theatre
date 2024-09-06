package com.github.kozlm.theatre.repository;

import com.github.kozlm.theatre.model.hall.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HallRepository extends JpaRepository<Hall, Long> {

}
