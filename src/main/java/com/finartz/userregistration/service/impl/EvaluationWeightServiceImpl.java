package com.finartz.userregistration.service.impl;

import com.finartz.userregistration.entity.Position;
import com.finartz.userregistration.repository.PositionRepository;
import com.finartz.userregistration.request.EvaluationWeightRequest;
import com.finartz.userregistration.entity.EvaluationWeight;
import com.finartz.userregistration.entity.Model;
import com.finartz.userregistration.repository.EvaluationWeightRepository;
import com.finartz.userregistration.repository.ModelRepository;
import com.finartz.userregistration.service.EvaluationWeightService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EvaluationWeightServiceImpl implements EvaluationWeightService {

    private final EvaluationWeightRepository evaluationWeightRepository;
    private final ModelRepository modelRepository;
    private final PositionRepository positionRepository;

    @Override
    public void saveEvaluationWeights(List<EvaluationWeightRequest> evaluationWeights) {
        Map<Integer, List<EvaluationWeightRequest>> weightsByModelId = evaluationWeights.stream()
                .collect(Collectors.groupingBy(EvaluationWeightRequest::getModelId));

        for (Map.Entry<Integer, List<EvaluationWeightRequest>> entry : weightsByModelId.entrySet()) {
            Integer modelId = entry.getKey();
            List<EvaluationWeightRequest> weights = entry.getValue();

            double totalWeight = weights.stream()
                    .mapToDouble(EvaluationWeightRequest::getWeight)
                    .sum();

            if (totalWeight != 100.0) {
                throw new IllegalArgumentException("Total weight for modelId " + modelId + " must be exactly 100");
            }

            Model model = modelRepository.findById(modelId)
                    .orElseThrow(() -> new IllegalArgumentException("Model with ID " + modelId + " does not exist"));

            for (EvaluationWeightRequest weightRequest : weights) {
                Position position = positionRepository.findById(weightRequest.getPositionId())
                        .orElseThrow(() -> new IllegalArgumentException("Position with ID " + weightRequest.getPositionId() + " does not exist"));

                EvaluationWeight evaluationWeight = new EvaluationWeight();
                evaluationWeight.setModelById(model);
                evaluationWeight.setPositionById(position);
                evaluationWeight.setWeight(weightRequest.getWeight());

                evaluationWeightRepository.save(evaluationWeight);
            }
        }
    }
}


