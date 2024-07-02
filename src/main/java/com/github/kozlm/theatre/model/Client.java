package com.github.kozlm.theatre.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_seq")
    @SequenceGenerator(name = "client_seq", sequenceName = "ClientSequence", allocationSize = 1)
    @Column(name = "ClientId")
    private Long id;

    @NotBlank
    @Column(name = "Name", nullable = false)
    private String name;

    @NotBlank
    @Column(name = "Surname", nullable = false)
    private String surname;

    @NotBlank
    @Column(name = "Gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotBlank
    @Pattern(regexp = "^[0-9]{9}$")
    @Column(name = "PhoneNumber", nullable = false, unique = true, length = 9)
    private String phoneNumber;

    @Email
    @NotBlank
    @Column(name = "Email", nullable = false, unique = true)
    private String email;

    @NotBlank
    @Column(name = "Password", nullable = false)
    private String password;

    @Past
    @Column(name = "DateOfBirth")
    private Date dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "AddressId", referencedColumnName = "AddressId")
    private Address address;

}
