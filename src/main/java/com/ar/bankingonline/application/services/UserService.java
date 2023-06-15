package com.ar.bankingonline.application.services;

import com.ar.bankingonline.api.controllers.mappers.UserMapper;
import com.ar.bankingonline.domain.models.User;
import com.ar.bankingonline.api.controllers.dtos.UserDto;
import com.ar.bankingonline.infrastructure.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
                .map(UserMapper::userMapToDto)
                .toList();
    }

    // TODO: Refactor
    public UserDto getUserById(Integer id){
        return UserMapper.userMapToDto(repository.findById(id).get());
    }


    public UserDto createUser(UserDto user){
        return UserMapper.userMapToDto(repository.save(UserMapper.dtoToUser(user)));
    }

    public UserDto update(UserDto user){
        return UserMapper.userMapToDto(repository.save(UserMapper.dtoToUser(user)));
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }


}
