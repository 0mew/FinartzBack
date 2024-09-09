package com.finartz.userregistration.service;


import com.finartz.userregistration.request.EvaluationWeightRequest;
import jakarta.validation.Valid;

import java.util.List;

public interface EvaluationWeightService {

    void saveEvaluationWeights(@Valid List<EvaluationWeightRequest> evaluationWeights);
}
