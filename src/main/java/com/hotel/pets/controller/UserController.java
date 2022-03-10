package com.hotel.pets.controller;

import com.hotel.pets.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("area")
    public String area(Model model, Authentication authentication) {
        model.addAttribute("booking", userService.getBooking(authentication.getName()));
        return "userArea";
    }

}
