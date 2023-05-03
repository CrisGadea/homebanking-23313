package com.ar.bankingonline.repositories;

import com.ar.bankingonline.models.User;
import com.ar.bankingonline.models.dtos.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDto, Integer> {
}
