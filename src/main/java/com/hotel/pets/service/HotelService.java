package com.hotel.pets.service;

import com.hotel.pets.model.entity.Offer;

import java.util.List;
import java.util.Map;

public interface HotelService {

    Map<String, List<Offer>> getOffers();
}
