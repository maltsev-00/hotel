package com.hotel.pets.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hotel")
public class HotelController {

    @GetMapping
    public String mainPage(){
        return "hotelMain";
    }
}
