package com.hotel.pets.service;

import com.hotel.pets.converter.UserConverter;
import com.hotel.pets.model.Role;
import com.hotel.pets.model.User;
import com.hotel.pets.model.UserDto;
import com.hotel.pets.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
    public Optional<User> findUserByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public Optional<User> findUserByPhone(String phone) {
        return Optional.empty();
    }

    @Override
    public Page<User> findAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<String> updateUser(User user) {
        return null;
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

}
