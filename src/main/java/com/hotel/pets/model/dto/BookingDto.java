package com.hotel.pets.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {

    private String firstName;
    private String lastName;
    private String nameAnimal;
    private String typeAnimal;
    private String telephoneNumber;
    private String infoAboutAnimal;
    private int countDay;
    private Long idMenu;
}
