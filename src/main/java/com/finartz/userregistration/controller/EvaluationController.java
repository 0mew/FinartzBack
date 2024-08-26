package com.finartz.userregistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.finartz.userregistration.entity.Evaluation;
import com.finartz.userregistration.request.CreateEvaluationRequest;
import com.finartz.userregistration.service.EvaluationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/evaluations")
public class EvaluationController {
    @Autowired
    private EvaluationService evaluationService;

    @PostMapping
    public ResponseEntity<Evaluation> saveEvaluation(@Valid @RequestBody CreateEvaluationRequest evaluationRequest) {
        return ResponseEntity.ok(evaluationService.saveEvaluation(evaluationRequest));
    }

    @GetMapping
    public Page<Evaluation> getEvaluations(@RequestParam(defaultValue = "0") int page, 
        @RequestParam(defaultValue = "10") int size) {
            Pageable pageable = PageRequest.of(page, size);
            return evaluationService.getEvaluations(pageable);
        }

    @DeleteMapping("/{evaluationId}")
    public ResponseEntity<String> deleteEvaluation(@PathVariable Long evaluationId) {
        evaluationService.deleteEvaluation(evaluationId);
        return ResponseEntity.ok("Evaluation deleted!");
    }

    @PutMapping("/{evaluationId}")
    public ResponseEntity<Evaluation> updateEvaluation(@PathVariable Long evaluationId, @RequestBody CreateEvaluationRequest createEvaluationRequest) {
        return ResponseEntity.ok(evaluationService.updateEvaluation(evaluationId, createEvaluationRequest));
    }
}
