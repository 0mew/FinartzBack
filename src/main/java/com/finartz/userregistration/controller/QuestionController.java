package com.finartz.userregistration.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.finartz.userregistration.entity.Question;
import com.finartz.userregistration.request.CreateQuestionRequest;
import com.finartz.userregistration.service.QuestionService;

@RestController
@RequestMapping("/api")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @PostMapping("/questions")
    public ResponseEntity<Question> saveQuestion(@RequestBody CreateQuestionRequest questionRequest) {
        return ResponseEntity.ok(questionService.saveQuestion(questionRequest));
    }

    @GetMapping("/competencies/{competencyId}/questions")
    public ResponseEntity<List<Question>> getQuestionsByCompetencyId(@PathVariable Long competencyId){
        return ResponseEntity.ok(questionService.getQuestionsByCompetencyId(competencyId));
    }

    @PutMapping("/questions/{questionId}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Long questionId, @RequestBody CreateQuestionRequest questionRequest) {
        return ResponseEntity.ok(questionService.updateQuestion(questionId, questionRequest));
    }

    @DeleteMapping("competencies/questions/{questionId}")
    public ResponseEntity<String> deletQuestion(@PathVariable Long questionId) {
        questionService.deleteQuestion(questionId);
        return ResponseEntity.status(HttpStatus.OK).body("Question deleted!");
    }
}
