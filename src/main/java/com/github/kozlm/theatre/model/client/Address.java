package com.github.kozlm.theatre.model.client;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    @SequenceGenerator(name = "address_seq", sequenceName = "AddressSequence", allocationSize = 1)
    @Column(name = "AddressId")
    private Long id;

    @Column(name = "PostalCode", nullable = false, length = 6)
    private String postalCode;

    @Column(name = "RoomNumber", length = 6)
    private String roomNumber;

    @Column(name = "BuildingNumber", nullable = false, length = 6)
    private String buildingNumber;

    @Column(name = "Street", nullable = false)
    private String street;

    @Column(name = "City", nullable = false)
    private String city;
}
