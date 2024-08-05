package com.github.kozlm.theatre.model.client;

import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;

@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
public class ClientDto {
    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private Gender gender;

    @NotBlank
    @Pattern(regexp = "^[0-9]{9}$")
    private String phoneNumber;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @Past
    private Date dateOfBirth;

    @Pattern(regexp = "^[0-9]{2}-[0-9]{3}$")
    private String postalCode;

    @Size(max = 6)
    private String roomNumber;

    @Size(max = 6)
    private String buildingNumber;

    private String street;

    private String city;

    public ClientDto(String name, String surname, Gender gender, String phoneNumber,
                     String email, String password, Date dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }

    public ClientDto(String name, String surname, Gender gender,
                     String phoneNumber, String email, String password,
                     String city, String street, String buildingNumber, String postalCode) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.postalCode = postalCode;
    }

    public ClientDto(String name, String surname, Gender gender, String phoneNumber,
                     String email, String password, Date dateOfBirth, String postalCode,
                     String buildingNumber, String street, String city) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.postalCode = postalCode;
        this.buildingNumber = buildingNumber;
        this.street = street;
        this.city = city;
    }

    public void setPassword(@NotBlank String password) {
        this.password = password;
    }
}
