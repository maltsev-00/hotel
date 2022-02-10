package com.hotel.pets.converter;

import com.hotel.pets.model.entity.User;
import com.hotel.pets.model.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserConverter {

    User convertToEntity(UserDto userDto);
}
