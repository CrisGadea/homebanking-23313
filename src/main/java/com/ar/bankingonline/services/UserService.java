package com.ar.bankingonline.services;

import com.ar.bankingonline.mappers.UserMapper;
import com.ar.bankingonline.models.User;
import com.ar.bankingonline.models.dtos.UserDto;
import com.ar.bankingonline.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    // Declaro una instancia del repositorio con @Autowired y sin la anotación
    @Autowired
    private final UserRepository repository;

    public UserService(UserRepository repository){
        this.repository = repository;
    }

    // Primero generar los metodos del CRUD

    public List<User> getUsers(){
        List<UserDto> usersDto = repository.findAll();
        return usersDto.stream()
                .map(UserMapper::dtoMapToUser)
                .toList();
    }

    // TODO: Refactor
    public User getUserById(Integer id){
        Optional<UserDto> userDto = repository.findById(id);
        return UserMapper.dtoMapToUser(userDto.get());
    }




}
