package com.hotel.pets.converter;

import com.hotel.pets.model.dto.QuestionUserDto;
import com.hotel.pets.model.entity.QuestionUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionUserConverter {

    QuestionUser convertToEntity(QuestionUserDto questionUserDto);
}
