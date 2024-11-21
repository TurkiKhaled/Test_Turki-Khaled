package com.example.test.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "User name is required")
    private String name;

    @Past(message = "Birthdate must be in the past")
    private LocalDate birthdate;

    @NotBlank(message = "Country of residence is required")
    private String country;

    private String phoneNumber;

    private String gender;



    // Vérifier si l'utilisateur est adulte
    public boolean isAdult() {
        return birthdate != null && LocalDate.now().minusYears(18).isAfter(birthdate);
    }

    // Vérifier si l'utilisateur est résident français
    public boolean isFrenchResident() {
        return "France".equalsIgnoreCase(country);
    }



    }
