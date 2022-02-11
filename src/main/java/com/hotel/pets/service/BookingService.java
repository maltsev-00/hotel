package com.hotel.pets.service;

import com.hotel.pets.model.dto.BookingDto;
import com.hotel.pets.model.entity.MenuItem;

import java.util.List;

public interface BookingService {
    void saveBooking(BookingDto bookingDto);

    List<MenuItem> findAll();
}
