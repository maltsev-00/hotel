package com.hotel.pets.controller;

import com.hotel.pets.model.Redirect;
import com.hotel.pets.model.dto.QuestionUserDto;
import com.hotel.pets.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping
    public String saveQuestion(@ModelAttribute("question") QuestionUserDto questionUserDto) {
        questionService.saveQuestion(questionUserDto);
        return Redirect.HOME;
    }
}
