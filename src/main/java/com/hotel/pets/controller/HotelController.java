package com.hotel.pets.controller;

import com.hotel.pets.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @GetMapping
    public String mainPage(Model model) {
        return "hotelMain";
    }

    @GetMapping("/offers")
    public String offers(Model model) {
        model.addAttribute("offers", hotelService.getOffers());
        return "hotelOffers";
    }


}
