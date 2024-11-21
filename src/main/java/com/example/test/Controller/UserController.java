package com.example.test.Controller;

import com.example.test.Entities.User;
import com.example.test.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users") // Préfixe de chemin global pour tous les endpoints
public class UserController {

    private final UserService userService;

    // Utilisation de l'injection par constructeur
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Enregistrement d'un utilisateur
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User savedUser = userService.registerUser(user);
        return ResponseEntity.ok(savedUser);
    }

    // Récupération des détails d'un utilisateur par ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userService.getUserDetails(id);
        if (user != null) {
            return ResponseEntity.ok(user);  // Retourne l'utilisateur avec un code 200 OK
        } else {
            return ResponseEntity.notFound().build();  // Retourne un code 404 Not Found si l'utilisateur n'existe pas
        }
    }
}
