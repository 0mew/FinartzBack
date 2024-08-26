package com.finartz.userregistration.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.finartz.userregistration.entity.Evaluation;
import com.finartz.userregistration.request.CreateEvaluationRequest;

public interface EvaluationService {
    Evaluation saveEvaluation(CreateEvaluationRequest evaluationRequest);
    Page<Evaluation> getEvaluations(Pageable pageable);
    public void deleteEvaluation(Long id);
    public Evaluation updateEvaluation(Long id, CreateEvaluationRequest evaluationRequest);
}
