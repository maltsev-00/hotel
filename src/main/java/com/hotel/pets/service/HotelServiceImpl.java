package com.hotel.pets.service;

import com.hotel.pets.model.dto.BookingDto;
import com.hotel.pets.model.dto.CostOffersDto;
import com.hotel.pets.model.entity.MenuItem;
import com.hotel.pets.model.entity.Offer;
import com.hotel.pets.model.entity.TypeOffer;
import com.hotel.pets.repository.OfferRepository;
import com.hotel.pets.repository.OfferTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final OfferRepository offerRepository;
    private final OfferTypeRepository offerTypeRepository;
    private final CostOffersService costOffersService;
    private final BookingService bookingService;

    @Override
    public Map<String, List<Offer>> getOffers() {
        List<TypeOffer> typeOffers = offerTypeRepository.findAll();
        Map<String, List<Offer>> offerListMap = new HashMap<>();
        typeOffers.forEach(typeOffer -> {
            var type = typeOffer.getName();
            offerListMap.put(type, offerRepository.findOfferByTypeOfferNameAndAccess(type, true));
        });
        return offerListMap;
    }

    @Override
    public List<CostOffersDto> getOffersCost() {
        return costOffersService.getOffersCost();
    }

    @Override
    public void saveBooking(BookingDto bookingDto,String email) {
        bookingService.saveBooking(bookingDto,email);
    }

    @Override
    public List<MenuItem> getMenuItems() {
        return bookingService.findAllMenuItems();
    }
}
