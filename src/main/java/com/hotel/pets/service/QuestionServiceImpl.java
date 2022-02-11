package com.hotel.pets.service;

import com.hotel.pets.converter.QuestionUserConverter;
import com.hotel.pets.model.dto.QuestionUserDto;
import com.hotel.pets.repository.QuestionUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionUserRepository questionUserRepository;
    private final QuestionUserConverter questionUserConverter;

    @Override
    public void saveQuestion(QuestionUserDto questionUserDto) {
        questionUserRepository.save(questionUserConverter.convertToEntity(questionUserDto));
    }
}
