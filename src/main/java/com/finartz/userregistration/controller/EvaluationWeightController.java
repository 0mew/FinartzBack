package com.finartz.userregistration.controller;

import com.finartz.userregistration.request.EvaluationWeightRequest;
import com.finartz.userregistration.service.EvaluationWeightService;
import com.finartz.userregistration.service.impl.EvaluationWeightServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api/evaluation-weights")
@RequiredArgsConstructor
public class EvaluationWeightController {

    private final EvaluationWeightServiceImpl evaluationWeightService;

    @PostMapping("/settings/weight")
    public ResponseEntity<String> saveEvaluationWeights(@RequestBody List<EvaluationWeightRequest> evaluationWeights) {
        try {
            evaluationWeightService.saveEvaluationWeights(evaluationWeights);
            return ResponseEntity.ok("Weights updated successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}

