package com.ar.bankingonline.controllers;

import com.ar.bankingonline.models.dtos.UserDto;
import com.ar.bankingonline.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service){
        this.service = service;
    }


    // Metodos HTTP
    // GET
    @GetMapping(value = "/users")
    public ResponseEntity<List<UserDto>> getUsers(){

        // 1) Obtener la lista de todos los DTO user de la DB
        // Agregar el servicio a la implementación del método del controlador
        List<UserDto> usuarios = service.getUsers();

        // 2) Devolver la lista y enviar como respuesta
        return ResponseEntity.status(200).body(usuarios);
    }

    // GET USER
    @GetMapping(value = "/users/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(service.getUserById(id));
    }

    // POST

    @PostMapping(value = "/users")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto dto){
        // Redirija hacia el responsable de crear un usuario en la DB
        return ResponseEntity.status(201).body(dto);
    }

    // PUT

    public void updateUser(UserDto user){

    }

    // DELETE

    public void deleteUser(Integer id){

    }

}
