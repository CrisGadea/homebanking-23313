package com.ar.bankingonline.controllers;

import com.ar.bankingonline.models.User;
import com.ar.bankingonline.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService service;

    public UserController(UserService service){
        this.service = service;
    }

    // Metodos HTTP
    // GET
    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getUsers(){

        // 1) Obtener la lista de todos los DTO user de la DB
        // Agregar el servicio a la implementación del método del controlador
        //List<User> usuarios = service.getUsers();

        // 2) Mapear la respuesta del DTO a una lista de objetos User (Mapper)



        List<User> usuarios = new ArrayList<>();
        User user = new User("cris", "1234");
        user.setId(1);
        usuarios.add(user);

        // 3) Devolver la lista y enviar como respuesta
        return ResponseEntity.ok().body(usuarios);
    }

    // POST

    @PostMapping(value = "/users")
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
