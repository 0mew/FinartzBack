package com.finartz.userregistration.request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateEvaluationRequest {
    private String termName;
    private String internalEvaluation;
    private String evaluationName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String email;
    private String phone;
}
