package com.finartz.userregistration.service;

import com.finartz.userregistration.Result.Result;
import com.finartz.userregistration.request.CreateMailTemplateRequest;
import com.finartz.userregistration.request.DeleteMailTemplateRequest;
import com.finartz.userregistration.request.UpdateMailTemplateRequest;
import com.finartz.userregistration.response.MailTemplateResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MailTemplateService {
    ResponseEntity<MailTemplateResponse> add(CreateMailTemplateRequest createTemplateMailRequest);
    Result delete(DeleteMailTemplateRequest deleteTempMailRequest);
    ResponseEntity<MailTemplateResponse> update(UpdateMailTemplateRequest updateTemplateMailRequest);
    ResponseEntity<MailTemplateResponse> getByid(Long id);
    ResponseEntity<List<MailTemplateResponse>> getAll();
}
