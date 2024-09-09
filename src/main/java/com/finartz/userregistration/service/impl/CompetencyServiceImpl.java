package com.finartz.userregistration.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finartz.userregistration.entity.Competency;
import com.finartz.userregistration.entity.Evaluation;
import com.finartz.userregistration.exception.ResourceNotFoundException;
import com.finartz.userregistration.repository.CompetencyRepository;
import com.finartz.userregistration.repository.EvaluationRepository;
import com.finartz.userregistration.request.CreateCompetencyRequest;
import com.finartz.userregistration.service.CompetencyService;

@Service
public class CompetencyServiceImpl implements CompetencyService{

    @Autowired 
    CompetencyRepository competencyRepository;

    @Autowired
    EvaluationRepository evaluationRepository;

    @Override
    public Competency saveCompetency(CreateCompetencyRequest competencyRequest) {
        Long evaluationId = competencyRequest.getEvaluationId();
        Evaluation evaluation = evaluationRepository.findById(evaluationId).orElseThrow(() -> new ResourceNotFoundException("Evaluation not found with id: " + evaluationId));

        Competency competency = Competency.builder()
        .name(competencyRequest.getName())
        .description(competencyRequest.getDescription())
        .evaluation(evaluation)
        .build();

        return competencyRepository.save(competency);
    }

    @Override
    public List<Competency> saveWeightSettings(Map<Long, Double> weightMap, Long evaluationId) throws IllegalAccessException {
        List<Competency> competencies = competencyRepository.findByEvaluationId(evaluationId);

        // Bu evaluationId'ye sahip competency'ler için verilen ağırlıkları topla
        Double totalWeight = weightMap.entrySet().stream()
                .filter(entry -> competencies.stream().anyMatch(c -> c.getId().equals(entry.getKey())))
                .mapToDouble(Map.Entry::getValue)
                .sum();

        // Toplam ağırlık 100 veya 0 olmalı
        if (totalWeight != 100.0 && totalWeight != 0.0) {
            throw new IllegalAccessException("Total weight must be exactly 100 or 0");
        }

        // Ağırlıkları güncelle
        for (Competency competency : competencies) {
            Double newWeight = weightMap.get(competency.getId());
            if (newWeight != null) {
                competency.setWeight(newWeight);
            } else {
                competency.setWeight(0.0);  // Eğer ağırlık haritada yoksa, varsayılan olarak 0.0 ayarla
            }
        }

        return competencyRepository.saveAll(competencies);

    }

    @Override
    public void deleteCompetency(Long id) {
        Competency competency = competencyRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Competency not found with id: " + id));

        competencyRepository.delete(competency);
    }

    @Override
    public List<Competency> getAllWeightSettings() {
        return competencyRepository.findAll();
    }

    @Override
    public List<Competency> getAllCompetencies() {
        return competencyRepository.findAll();
    }

    @Override
    public Competency updateCompetency(Long id, CreateCompetencyRequest competencyRequest) {
        Competency updatedCompetency = competencyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Competency not found with id: " + id));

        Evaluation evaluation = evaluationRepository.findById(competencyRequest.getEvaluationId()).orElseThrow(() -> new ResourceNotFoundException("Evaluation not found with id: " + id));

        updatedCompetency.setName(competencyRequest.getName());
        updatedCompetency.setDescription(competencyRequest.getDescription());
        updatedCompetency.setEvaluation(evaluation);

        return competencyRepository.save(updatedCompetency);
    }
}
