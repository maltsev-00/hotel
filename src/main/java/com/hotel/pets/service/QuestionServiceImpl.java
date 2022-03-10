package com.hotel.pets.service;

import com.hotel.pets.converter.QuestionUserConverter;
import com.hotel.pets.model.dto.QuestionUserDto;
import com.hotel.pets.model.entity.QuestionUser;
import com.hotel.pets.repository.QuestionUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionUserRepository questionUserRepository;
    private final QuestionUserConverter questionUserConverter;

    @Override
    public void saveQuestion(QuestionUserDto questionUserDto) {
        QuestionUser questionUser = questionUserConverter.convertToEntity(questionUserDto);
        questionUser.setTime(LocalDate.now());
        questionUserRepository.save(questionUser);
    }

    @Override
    public List<QuestionUser> findAll() {
        return questionUserRepository.findAll();
    }
}
