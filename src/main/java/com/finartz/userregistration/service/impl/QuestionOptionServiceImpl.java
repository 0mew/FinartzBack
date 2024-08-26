package com.finartz.userregistration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finartz.userregistration.entity.Option;
import com.finartz.userregistration.entity.Question;
import com.finartz.userregistration.entity.QuestionOption;
import com.finartz.userregistration.exception.ResourceNotFoundException;
import com.finartz.userregistration.repository.OptionRepository;
import com.finartz.userregistration.repository.QuestionOptionRepository;
import com.finartz.userregistration.repository.QuestionRepository;
import com.finartz.userregistration.request.CreateQuestionOptionRequest;
import com.finartz.userregistration.service.QuestionOptionService;


@Service
public class QuestionOptionServiceImpl implements QuestionOptionService{

    @Autowired
    QuestionOptionRepository questionOptionRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    OptionRepository optionRepository;

    @Override
    public void saveQuestionOption(CreateQuestionOptionRequest request) {
        Long questionId = request.getQuestionId();
        Question question = questionRepository.findById(questionId).orElseThrow(() -> new ResourceNotFoundException("Question not found with id: " + questionId));

        Option option = optionRepository.findById(request.getOptionId())
                .orElseThrow(() -> new ResourceNotFoundException("Option not found with id: " + request.getOptionId()));

        QuestionOption questionOption = QuestionOption.builder()
        .question(question)
        .option(option)
        .isMandatory(request.getIsMandatory())
        .isHidden(request.getIsHidden())
        .build();

        questionOptionRepository.save(questionOption);
    }
}
