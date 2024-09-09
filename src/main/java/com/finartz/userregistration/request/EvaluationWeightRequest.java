package com.finartz.userregistration.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationWeightRequest {


    private Integer modelId;
    private Integer positionId;
    private Integer weight;
}