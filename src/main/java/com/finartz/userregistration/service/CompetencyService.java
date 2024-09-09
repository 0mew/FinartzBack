package com.finartz.userregistration.service;

import java.util.List;
import java.util.Map;

import com.finartz.userregistration.entity.Competency;
import com.finartz.userregistration.request.CreateCompetencyRequest;

public interface CompetencyService {
    Competency saveCompetency(CreateCompetencyRequest competencyRequest);
    List<Competency> getAllCompetencies();
    Competency updateCompetency(Long id, CreateCompetencyRequest competencyRequest);
    void deleteCompetency(Long id);
    List<Competency> saveWeightSettings(Map<Long, Double> weightMap, Long evaluationId) throws IllegalAccessException;
    List<Competency> getAllWeightSettings();
}
