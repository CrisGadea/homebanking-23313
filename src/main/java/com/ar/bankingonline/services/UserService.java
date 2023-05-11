package com.ar.bankingonline.services;

import com.ar.bankingonline.mappers.UserMapper;
import com.ar.bankingonline.models.User;
import com.ar.bankingonline.models.dtos.UserDto;
import com.ar.bankingonline.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    // Declaro una instancia del repositorio con @Autowired y sin la anotación
    @Autowired
    private UserRepository repository;

    public UserService(UserRepository repository){
        this.repository = repository;
    }


    // Primero generar los metodos del CRUD

    public List<UserDto> getUsers(){
        List<User> users = repository.findAll();
        return users.stream()
                .map(UserMapper::dtoMapToDto)
                .toList();
    }

    // TODO: Refactor
    public UserDto getUserById(Integer id){
        Optional<User> user = repository.findById(id);
        return UserMapper.dtoMapToDto(user.get());
    }




}
