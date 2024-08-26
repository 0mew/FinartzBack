package com.finartz.userregistration.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finartz.userregistration.request.CreateQuestionOptionRequest;
import com.finartz.userregistration.service.QuestionOptionService;

@RestController
@RequestMapping("/api/question-options")

public class QuestionOptionController {

    @Autowired
    QuestionOptionService questionOptionService;


    @PostMapping
    public ResponseEntity<Void> saveQuestionOption(@RequestBody CreateQuestionOptionRequest request) {
        questionOptionService.saveQuestionOption(request);
        return ResponseEntity.ok().build();
    }
}
