package com.github.kozlm.theatre.repository;

import com.github.kozlm.theatre.model.client.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
