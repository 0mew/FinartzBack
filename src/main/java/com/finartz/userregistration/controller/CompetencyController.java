package com.finartz.userregistration.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.finartz.userregistration.entity.Competency;
import com.finartz.userregistration.request.CreateCompetencyRequest;
import com.finartz.userregistration.service.CompetencyService;


@RestController
@RequestMapping("/api/competencies")
public class CompetencyController {
    @Autowired
    CompetencyService competencyService;

    @PostMapping
    public ResponseEntity<Competency> saveCompetency(@RequestBody CreateCompetencyRequest competencyRequest) {
        return ResponseEntity.ok(competencyService.saveCompetency(competencyRequest));
    }

    @GetMapping
    public ResponseEntity<List<Competency>> getAllCompetencies() {
        return ResponseEntity.ok(competencyService.getAllCompetencies());
    }


    @PutMapping("/{competencyId}")
    public ResponseEntity<Competency> updateCompetency(@PathVariable Long competencyId, @RequestBody CreateCompetencyRequest competencyRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(competencyService.updateCompetency(competencyId, competencyRequest));
    }

    @DeleteMapping("/{competencyId}")
    public ResponseEntity<String> deleteCompetency(@PathVariable Long competencyId) {
        competencyService.deleteCompetency(competencyId);
        return ResponseEntity.status(HttpStatus.OK).body("Competency deleted!");
    }

    @PutMapping("/settings/weight")
    public ResponseEntity<List<Competency>> saveWeightSettings(@RequestParam Long evaluationId, @RequestBody Map<Long, Double> weightMap) {
        try {
            List<Competency> updatedCompetencies = competencyService.saveWeightSettings(weightMap, evaluationId);
            return ResponseEntity.ok(updatedCompetencies);
        } catch (IllegalAccessException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/settings/weight")
    public ResponseEntity<List<Competency>> getAllWeightSettings() {
        return ResponseEntity.ok(competencyService.getAllWeightSettings());
    }

}
