package com.finartz.userregistration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.finartz.userregistration.entity.OptionEnum;
import com.finartz.userregistration.entity.Question;
import com.finartz.userregistration.entity.QuestionOption;
import com.finartz.userregistration.exception.ResourceNotFoundException;
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

    @Override
    public void saveQuestionOption(CreateQuestionOptionRequest request) {
        Long questionId = request.getQuestionId();
        Question question = questionRepository.findById(questionId)
            .orElseThrow(() -> new ResourceNotFoundException("Question not found with id: " + questionId));

        // Use the OptionEnum directly
        OptionEnum optionEnum = request.getOptionEnum();

        QuestionOption questionOption = QuestionOption.builder()
            .question(question)
            .option(optionEnum)
            .isMandatory(request.getIsMandatory())
            .isHidden(request.getIsHidden())
            .build();

        questionOptionRepository.save(questionOption);
    }
}
