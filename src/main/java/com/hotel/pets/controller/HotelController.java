package com.hotel.pets.controller;

import com.hotel.pets.model.PageName;
import com.hotel.pets.model.Redirect;
import com.hotel.pets.model.dto.BookingDto;
import com.hotel.pets.model.dto.QuestionUserDto;
import com.hotel.pets.model.entity.MenuItem;
import com.hotel.pets.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/hotels")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @GetMapping
    public String mainPage(Model model, Authentication authentication) {
        model.addAttribute("question", new QuestionUserDto());
        return PageName.HOME;
    }

    @GetMapping("/offers")
    public String offers(Model model) {
        model.addAttribute("offers", hotelService.getOffers());
        return PageName.HOTEL_OFFERS;
    }

    @GetMapping("offers/cost")
    public String offersCost(Model model) {
        model.addAttribute("offersCost", hotelService.getOffersCost());
        return PageName.OFFERS_COST;
    }

    @GetMapping("/booking")
    public String newBooking(Model model) {
        model.addAttribute("booking", new BookingDto());
        List<MenuItem> menuItems = hotelService.getMenuItems();
        model.addAttribute("menu", menuItems);
        model.addAttribute("sizeMenu", menuItems.size());
        return "add-new-booking";
    }

    @PostMapping("/booking")
    public String saveBooking(@ModelAttribute("booking") BookingDto bookingDto, Authentication authentication) {
        String email = authentication.getName();
        hotelService.saveBooking(bookingDto, email);
        return Redirect.HOME;
    }

}
