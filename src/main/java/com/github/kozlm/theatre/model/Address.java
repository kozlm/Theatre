package com.github.kozlm.theatre.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    @SequenceGenerator(name = "address_seq", sequenceName = "AddressSequence", allocationSize = 1)
    @Column(name = "AddressId")
    private Long id;

    @NotBlank
    @Pattern(regexp = "^[0-9]{2}-[0-9]{3}$")
    @Column(name = "PostalCode", nullable = false, length = 6)
    private String postalCode;

    @Size(max = 6)
    @Column(name = "RoomNumber", length = 6)
    private String roomNumber;

    @NotBlank
    @Size(max = 6)
    @Column(name = "BuildingNumber", nullable = false, length = 6)
    private String buildingNumber;

    @NotBlank
    @Column(name = "Street", nullable = false)
    private String street;

    @NotBlank
    @Column(name = "City", nullable = false)
    private String city;

}
