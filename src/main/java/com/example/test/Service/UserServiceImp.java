package com.example.test.Service;

import com.example.test.Entities.User;
import com.example.test.Repository.UserRepository;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.time.LocalDate;
import java.time.Period;

@AllArgsConstructor
@Service
public class UserServiceImp implements UserService{

    private UserRepository userRepository;


    @Override
    public User registerUser(User user) {
        if (!user.getCountry().equalsIgnoreCase("France")) {
            throw new IllegalArgumentException("Seuls les résidents français peuvent créer un compte");
        }
        if (user.getBirthdate() != null && Period.between(user.getBirthdate(), LocalDate.now()).getYears() < 18) {
            throw new IllegalArgumentException("Seuls les majeurs peuvent créer un compte");
        }
        return userRepository.save(user);
    }

    @Override
    public User getUserDetails(Long id) {
        return userRepository.findById(id)
                .orElse(null) ;
    }



}
