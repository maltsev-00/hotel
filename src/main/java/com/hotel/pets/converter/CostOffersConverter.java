package com.hotel.pets.converter;

import com.hotel.pets.model.dto.CostOffersDto;
import com.hotel.pets.model.entity.CostOffers;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CostOffersConverter {

    List<CostOffersDto> convertToDto(List<CostOffers> costOffers);
}
