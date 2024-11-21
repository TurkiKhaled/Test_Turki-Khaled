package com.example.test.Service;

import com.example.test.Entities.User;
import com.example.test.Repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.Month;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class) // Assurez-vous d'ajouter cette annotation
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImp userService;

    private User user;

    private static final LocalDate UNDERAGE_DATE = LocalDate.of(2010, Month.JANUARY, 1);
    private static final LocalDate ADULT_DATE = LocalDate.of(2000, Month.JANUARY, 1);

    @BeforeEach
    void setUp() {
        user = new User(null, "Turki Khaled", ADULT_DATE, "france", "0123456789", "Male");
    }

    @Test
    void testRegisterUser() {
        // Simuler l'enregistrement de l'utilisateur
        when(userRepository.save(any(User.class))).thenReturn(user);

        User savedUser = userService.registerUser(user);

        assertNotNull(savedUser);
        assertEquals("Turki Khaled", savedUser.getName());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testRegisterUserUnderage() {
        user.setBirthdate(UNDERAGE_DATE);

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> userService.registerUser(user));
        assertEquals("Seuls les majeurs peuvent créer un compte", thrown.getMessage()); // Vérifier le message de l'exception
    }

    @Test
    void testRegisterUserNonFrench() {
        user.setCountry("USA");

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> userService.registerUser(user));
        assertEquals("Seuls les résidents français peuvent créer un compte", thrown.getMessage()); // Vérifier le message de l'exception
    }

    @Test
    void testGetUserDetails() {
        user.setId(1L);
        when(userRepository.findById(1L)).thenReturn(java.util.Optional.of(user));

        User foundUser = userService.getUserDetails(1L);

        assertNotNull(foundUser);
        assertEquals("Turki Khaled", foundUser.getName());
    }

    @Test
    void testGetUserDetailsNotFound() {
        when(userRepository.findById(1L)).thenReturn(java.util.Optional.empty());

        User foundUser = userService.getUserDetails(1L);

        assertNull(foundUser);
    }
}
