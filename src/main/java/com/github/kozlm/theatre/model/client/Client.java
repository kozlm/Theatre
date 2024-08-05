package com.github.kozlm.theatre.model.client;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Data
@Builder
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_seq")
    @SequenceGenerator(name = "client_seq", sequenceName = "ClientSequence", allocationSize = 1)
    @Column(name = "ClientId")
    private Long id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Surname", nullable = false)
    private String surname;

    @Column(name = "Gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "PhoneNumber", nullable = false, unique = true, length = 9)
    private String phoneNumber;

    @Column(name = "Email", nullable = false, unique = true)
    private String email;

    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "DateOfBirth")
    private Date dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "AddressId", referencedColumnName = "AddressId")
    private Address address;
}
