package com.hotel.pets.service;

import com.hotel.pets.model.dto.BookingDto;
import com.hotel.pets.model.entity.Booking;
import com.hotel.pets.model.entity.MenuItem;
import com.hotel.pets.repository.BookingRepository;
import com.hotel.pets.repository.MenuItemRepository;
import lombok.RequiredArgsConstructor;
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

    @Override
    public void saveBooking(BookingDto bookingDto) {

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

        bookingRepository.save(booking);
    }

    @Override
    public List<MenuItem> findAll() {
        return menuItemRepository.findAll();
    }
}
