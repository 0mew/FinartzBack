package com.finartz.userregistration.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CreateMailTemplateRequest
{
    @NotEmpty
    private String title;
    private String description;
    private boolean updateAllActiveEvaluations;


}


