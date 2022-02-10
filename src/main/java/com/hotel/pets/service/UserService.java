package com.hotel.pets.service;

import com.hotel.pets.model.entity.User;
import com.hotel.pets.model.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findUserByUsername(String username);
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByPhone(String phone);

    Page<User> findAllUsers(Pageable pageable);
    List<User> findAllUsers();
    List<String> updateUser(User user);
    void addUser(UserDto user);

    Optional<User> findById(int id);
}
