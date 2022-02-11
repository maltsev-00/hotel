package com.hotel.pets.service;

import com.hotel.pets.converter.UserConverter;
import com.hotel.pets.model.dto.UserDto;
import com.hotel.pets.model.entity.Booking;
import com.hotel.pets.model.entity.Role;
import com.hotel.pets.model.entity.User;
import com.hotel.pets.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private static final String ROLE_USER = "ROLE_USER";

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public void addUser(UserDto userDto) {
        User newUser = userConverter.convertToEntity(userDto);
        newUser.setRoles(List.of(new Role(ROLE_USER)));
        newUser.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        userRepository.save(newUser);
    }

    @Override
    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<Booking> getBooking(String email) {
        User user = findUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email " + email + " not found"));
        return new ArrayList<>(user.getBookings());
    }

}
