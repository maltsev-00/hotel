package com.hotel.pets.controller;

import com.hotel.pets.model.entity.MenuItem;
import com.hotel.pets.service.BookingService;
import com.hotel.pets.service.CostOffersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final BookingService bookingService;
    private final CostOffersService costOffersService;

    @GetMapping
    public String homepage(Model model) {
        model.addAttribute("costs", costOffersService.getOffersCost());
        return "adminHome";
    }

    @GetMapping("/menu")
    public String menu(Model model) {
        model.addAttribute("menu", new MenuItem());
        model.addAttribute("listBooking", bookingService.findAllMenuItems());
        return "menu";
    }

    @PostMapping("/menu/{id}")
    public String deleteMenu(@PathVariable("id") Long id) {
        bookingService.deleteMenu(id);
        return "redirect:/admin/menu";
    }

    @PostMapping("/menu")
    public String saveMenu(@ModelAttribute("menu") MenuItem menuItem) {
        bookingService.saveMenuItem(menuItem);
        return "redirect:/admin/menu";
    }

}
