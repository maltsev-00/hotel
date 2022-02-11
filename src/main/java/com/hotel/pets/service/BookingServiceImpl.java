package com.hotel.pets.service;

import com.hotel.pets.model.dto.BookingDto;
import com.hotel.pets.model.entity.Booking;
import com.hotel.pets.model.entity.MenuItem;
import com.hotel.pets.model.entity.User;
import com.hotel.pets.repository.BookingRepository;
import com.hotel.pets.repository.MenuItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final MenuItemRepository menuItemRepository;
    private final UserService userService;

    @Override
    public void saveBooking(BookingDto bookingDto, String email) {

        MenuItem menuItemById = menuItemRepository.findMenuItemById(bookingDto.getIdMenu());

        Set<MenuItem> menuItems = new HashSet<>();
        menuItems.add(menuItemById);

        BigDecimal finalCost = BigDecimal.ONE.add(menuItemById.getCost()).divide(new BigDecimal(bookingDto.getCountDay()));
        Booking booking = Booking.builder()
                .countDay(bookingDto.getCountDay())
                .infoAboutAnimal(bookingDto.getInfoAboutAnimal())
                .nameAnimal(bookingDto.getNameAnimal())
                .typeAnimal(bookingDto.getTypeAnimal())
                .telephoneNumber(bookingDto.getTelephoneNumber())
                .menuItems(menuItems)
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
