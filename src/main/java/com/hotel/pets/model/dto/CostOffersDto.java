package com.hotel.pets.model.dto;

import com.hotel.pets.model.entity.AdditionallyOffers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CostOffersDto {
    private String name;
    private BigDecimal cost;
    private List<AdditionallyOffers> additionallyOffers;
}
