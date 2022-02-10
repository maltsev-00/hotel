package com.hotel.pets.service;

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

    @Override
    public Map<String, List<Offer>> getOffers() {
        List<TypeOffer> typeOffers = offerTypeRepository.findAll();
        Map<String, List<Offer>> offerListMap = new HashMap<>();
        typeOffers.forEach(typeOffer -> {
            var type = typeOffer.getName();
            offerListMap.put(type, offerRepository.findOfferByTypeOfferName(type));
        });
        return offerListMap;
    }
}
