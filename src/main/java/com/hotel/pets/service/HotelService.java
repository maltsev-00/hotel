package com.hotel.pets.service;

import com.hotel.pets.model.dto.BookingDto;
import com.hotel.pets.model.dto.CostOffersDto;
import com.hotel.pets.model.entity.MenuItem;
import com.hotel.pets.model.entity.Offer;

import java.util.List;
import java.util.Map;

public interface HotelService {

    Map<String, List<Offer>> getOffers();

    List<CostOffersDto> getOffersCost();

    void saveBooking(BookingDto bookingDto,String email);

    List<MenuItem> getMenuItems();
}
