package com.finartz.userregistration.service;

import java.util.List;

import com.finartz.userregistration.entity.Question;
import com.finartz.userregistration.request.CreateQuestionRequest;

public interface QuestionService {
    Question saveQuestion(CreateQuestionRequest questionRequest);
    List<Question> getQuestionsByCompetencyId(Long id);
    public Question updateQuestion(Long id, CreateQuestionRequest questionRequest);
    void deleteQuestion(Long id);
}
