package com.finartz.userregistration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.finartz.userregistration.entity.Evaluation;
import com.finartz.userregistration.exception.ResourceNotFoundException;
import com.finartz.userregistration.repository.EvaluationRepository;
import com.finartz.userregistration.request.CreateEvaluationRequest;
import com.finartz.userregistration.service.EvaluationService;


@Service
public class EvaluationServiceImpl implements EvaluationService{
    @Autowired
    private EvaluationRepository evaluationRepository;

    @Override
    public Evaluation saveEvaluation(CreateEvaluationRequest evaluationRequest) {
        var evaluation = Evaluation.builder()
        .termName(evaluationRequest.getTermName())
        .internalEvaluation(evaluationRequest.getInternalEvaluation())
        .evaluationName(evaluationRequest.getEvaluationName())
        .startDate(evaluationRequest.getStartDate())
        .endDate(evaluationRequest.getEndDate())
        .email(evaluationRequest.getEmail())
        .phone(evaluationRequest.getPhone())
        .build();

        evaluationRepository.save(evaluation);
        return evaluation;
    }

    @Override
    public Page<Evaluation> getEvaluations(Pageable pageable) {
        return evaluationRepository.findAll(pageable);
    }

    @Override
    public void deleteEvaluation(Long id) {
        evaluationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Evaluation not found with id: " + id));
        evaluationRepository.deleteById(id);
    }

    @Override
    public Evaluation updateEvaluation(Long id, CreateEvaluationRequest createEvaluationRequest) {
        Evaluation updatedEvaluation = evaluationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Evaluation not found with id: " + id));
        updatedEvaluation.setTermName(createEvaluationRequest.getTermName());
        updatedEvaluation.setInternalEvaluation(createEvaluationRequest.getInternalEvaluation());
        updatedEvaluation.setEvaluationName(createEvaluationRequest.getEvaluationName());
        updatedEvaluation.setStartDate(createEvaluationRequest.getStartDate());
        updatedEvaluation.setEndDate(createEvaluationRequest.getEndDate());
        updatedEvaluation.setEmail(createEvaluationRequest.getEmail());
        updatedEvaluation.setPhone(createEvaluationRequest.getPhone());

        return evaluationRepository.save(updatedEvaluation);
    }
    
}
