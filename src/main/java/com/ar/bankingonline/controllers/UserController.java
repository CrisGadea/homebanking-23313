package com.ar.bankingonline.controllers;

import com.ar.bankingonline.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    public UserController(){}

    // Metodos HTTP
    // GET
    @GetMapping(value = "/users")
    public ResponseEntity<User> getUsers(){
        // Obtener la lista de todos los user de la DB
        //List<User> usuarios = new ArrayList<>();
        User user = new User("cris", "1234");
        user.setId(1);
        return ResponseEntity.ok().body(user);
    }

    // POST

    @PostMapping(value = "/user")
    public ResponseEntity<User> createUser(@RequestBody User user){
        // Redirija hacia el responsable de crear un usuario en la DB
        return ResponseEntity.status(201).body(user);
    }

    // PUT

    public void updateUser(User user){

    }

    // DELETE

    public void deleteUser(Integer id){

    }

}
