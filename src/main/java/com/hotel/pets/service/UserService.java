package com.hotel.pets.service;

import com.hotel.pets.model.entity.Booking;
import com.hotel.pets.model.entity.User;
import com.hotel.pets.model.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findUserByEmail(String email);

    void addUser(UserDto user);

    Optional<User> findById(int id);

    void save(User user);

    List<Booking> getBooking(String email);
}
