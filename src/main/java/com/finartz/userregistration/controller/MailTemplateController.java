package com.finartz.userregistration.controller;

import com.finartz.userregistration.Result.Result;
import com.finartz.userregistration.request.CreateMailTemplateRequest;
import com.finartz.userregistration.request.DeleteMailTemplateRequest;
import com.finartz.userregistration.request.UpdateMailTemplateRequest;
import com.finartz.userregistration.response.MailTemplateResponse;
import com.finartz.userregistration.service.MailTemplateService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/template/settings")
@AllArgsConstructor
public class MailTemplateController {
    @Autowired
    private MailTemplateService mailTemplateService;

    @PostMapping("/add")
    public ResponseEntity<MailTemplateResponse> add(@RequestBody CreateMailTemplateRequest createTemplateMailRequest) {
        return mailTemplateService.add(createTemplateMailRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@RequestBody @Valid DeleteMailTemplateRequest deleteTempMailRequest){
        Result result=this.mailTemplateService.delete(deleteTempMailRequest);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
    @PutMapping("/{id}")
    public ResponseEntity<MailTemplateResponse> update(@RequestBody UpdateMailTemplateRequest updateTemplateMailRequest){
        return mailTemplateService.update(updateTemplateMailRequest);
    }
    @GetMapping(value = "/{id}")
    public  ResponseEntity<MailTemplateResponse> getById(@PathVariable @Valid Long id){
        return mailTemplateService.getByid(id);
    }

    @GetMapping
    public ResponseEntity<List<MailTemplateResponse>> getAll (){
        return mailTemplateService.getAll();
    }





}
