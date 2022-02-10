package com.hotel.pets.service;

import com.hotel.pets.converter.CostOffersConverter;
import com.hotel.pets.model.dto.CostOffersDto;
import com.hotel.pets.repository.CostOffersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CostOffersServiceImpl implements CostOffersService {

    private final CostOffersRepository costOffersRepository;
    private final CostOffersConverter costOffersConverter;

    @Override
    public List<CostOffersDto> getOffersCost() {
        return costOffersConverter.convertToDto(costOffersRepository.findAll());
    }
}
