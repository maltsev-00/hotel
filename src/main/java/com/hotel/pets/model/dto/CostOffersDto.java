package com.hotel.pets.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CostOffersDto {
    private String name;
    private BigDecimal cost;
    private String additionally;
}
