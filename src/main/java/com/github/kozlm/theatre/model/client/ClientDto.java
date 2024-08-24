package com.github.kozlm.theatre.model.client;

import com.github.kozlm.theatre.validation.FieldsEmptyOrFilled;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;


@Data
@FieldsEmptyOrFilled(
        necessaryFieldNames = {"postalCode", "buildingNumber", "street", "city"},
        nonNecessaryFieldNames = {"roomNumber"}
)
public class ClientDto {
    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotNull
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

    @Size(max = 6, min = 1)
    private String roomNumber;

    @Size(max = 6, min = 1)
    private String buildingNumber;

    @Size(min = 3)
    private String street;

    @Size(min = 1)
    private String city;
}
