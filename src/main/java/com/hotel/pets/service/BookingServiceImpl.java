package com.hotel.pets.service;

import com.hotel.pets.model.dto.BookingDto;
import com.hotel.pets.model.entity.Booking;
import com.hotel.pets.model.entity.MenuItem;
import com.hotel.pets.model.entity.User;
import com.hotel.pets.repository.MenuItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final MenuItemRepository menuItemRepository;
    private final UserService userService;

    @Override
    public void saveBooking(BookingDto bookingDto, String email) {

        MenuItem menuItemById = menuItemRepository.findMenuItemById(bookingDto.getIdMenu());
        BigDecimal finalCost = menuItemById.getCost().multiply(BigDecimal.valueOf(bookingDto.getCountDay()));

        Booking booking = Booking.builder()
                .countDay(bookingDto.getCountDay())
                .infoAboutAnimal(bookingDto.getInfoAboutAnimal())
                .nameAnimal(bookingDto.getNameAnimal())
                .typeAnimal(bookingDto.getTypeAnimal())
                .telephoneNumber(bookingDto.getTelephoneNumber())
                .menuItems(List.of(menuItemById))
                .finalCost(finalCost)
                .build();

        User user = userService.findUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email " + email + " not found"));
        user.getBookings().add(booking);
        userService.save(user);
    }

    @Override
    public List<MenuItem> findAllMenuItems() {
        return menuItemRepository.findAll();
    }

    @Override
    public void deleteMenu(Long id) {
        menuItemRepository.deleteById(id);
    }

    @Override
    public void saveMenuItem(MenuItem menuItem) {
        menuItemRepository.save(menuItem);
    }
}
