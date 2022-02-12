package com.hotel.pets.service;

import com.hotel.pets.model.dto.QuestionUserDto;
import com.hotel.pets.model.entity.QuestionUser;

import java.util.List;

public interface QuestionService {

    void saveQuestion(QuestionUserDto questionUserDto);

    List<QuestionUser> findAll();
}
