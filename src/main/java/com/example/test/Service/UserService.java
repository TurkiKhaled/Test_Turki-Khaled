package com.example.test.Service;

import com.example.test.Entities.User;
import org.springframework.validation.BindingResult;

import java.security.Principal;
import java.util.List;

public interface UserService {
    User registerUser(User user) ;
    User getUserDetails(Long id);

}
