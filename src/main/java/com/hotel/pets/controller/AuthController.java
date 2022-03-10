package com.hotel.pets.controller;

import com.hotel.pets.model.PageName;
import com.hotel.pets.model.Redirect;
import com.hotel.pets.model.dto.UserDto;
import com.hotel.pets.model.entity.User;
import com.hotel.pets.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping("login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("registration")
    public String newUser(Model model) {
        model.addAttribute("userDto", new UserDto());
        return PageName.REGISTRATION;
    }

    @PostMapping("registration")
    public String registerUser(@ModelAttribute("userDto") @Valid UserDto userDto, BindingResult result) {
        Optional<User> existing = userService.findUserByEmail(userDto.getEmail());
        if (existing.isPresent()) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (result.hasErrors()) {
            return PageName.REGISTRATION;
        }
        userService.addUser(userDto);
        return Redirect.SUCCESS_REGISTRATION;
    }
}
