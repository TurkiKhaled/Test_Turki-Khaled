package com.example.test.Entities;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private static Validator validator;

    @BeforeAll
    static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testIsAdult_Valid() {
        User user = new User(null, "Turki Khaled", LocalDate.now().minusYears(20), "France", "0123456789", "Male");
        assertTrue(user.isAdult());
    }

    @Test
    void testValidation_NameNotBlank() {
        User user = new User(null, "", LocalDate.of(2000, 1, 1), "France", "0123456789", "Male");
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertFalse(violations.isEmpty());
    }
}
