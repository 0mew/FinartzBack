package com.finartz.userregistration.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCompetencyRequest {
    private String name;
    private String description;
    private Long evaluationId;
    private Double weight;
}
