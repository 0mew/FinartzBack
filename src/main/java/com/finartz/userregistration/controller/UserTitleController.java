package com.finartz.userregistration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finartz.userregistration.entity.UserTitle;
import com.finartz.userregistration.request.TitleRequest;
import com.finartz.userregistration.service.UserTitleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/titles")
public class UserTitleController {
    @Autowired
    private UserTitleService userTitleService;

    @PostMapping
    public ResponseEntity<UserTitle> createUserTitle(@Valid @RequestBody TitleRequest titleRequest) {
        UserTitle userTitle = userTitleService.createUserTitle(titleRequest.getTitle());
        return ResponseEntity.ok(userTitle);
    }

    @GetMapping()
    public ResponseEntity<List<UserTitle>> getAllUserTitles() {
        List<UserTitle> userTitles = userTitleService.getAllUserTitles();
        return ResponseEntity.ok(userTitles);
    }
}
