package com.finartz.userregistration.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finartz.userregistration.entity.Competency;
import com.finartz.userregistration.entity.Question;
import com.finartz.userregistration.exception.ResourceNotFoundException;
import com.finartz.userregistration.repository.CompetencyRepository;
import com.finartz.userregistration.repository.QuestionRepository;
import com.finartz.userregistration.request.CreateQuestionRequest;
import com.finartz.userregistration.service.QuestionService;


@Service
public class QuestionServiceImpl implements QuestionService{
    @Autowired
    CompetencyRepository competencyRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public Question saveQuestion(CreateQuestionRequest questionRequest) {
        Long competencyId = questionRequest.getCompetencyId();
        Competency competency = competencyRepository.findById(competencyId).orElseThrow(() -> new ResourceNotFoundException("Competency not found with id: " + competencyId));

        Question question = Question.builder()
        .content(questionRequest.getContent())
        .competency(competency)
        .build();

        return questionRepository.save(question);
    }

    @Override
    public List<Question> getQuestionsByCompetencyId(Long id) {
        return questionRepository.findByCompetencyId(id);
    } 

    @Override
    public void deleteQuestion(Long id) {
       Question question = questionRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Question not found with id: " + id));

        questionRepository.delete(question);
    }

    @Override
    public Question updateQuestion(Long id, CreateQuestionRequest questionRequest) {
        Question updatedQuestion = questionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Question not found with id: " + id));
        updatedQuestion.setContent(questionRequest.getContent());

        Competency competency = competencyRepository.findById(questionRequest.getCompetencyId()).orElseThrow(() -> new ResourceNotFoundException("Competency not found with id: " + id));

        updatedQuestion.setCompetency(competency);

        return questionRepository.save(updatedQuestion);
    }

   

}
