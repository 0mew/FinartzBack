package com.finartz.userregistration.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UpdateMailTemplateRequest {
    @NotNull
    private Long id;

    private String title;
    private String description;
    private boolean updateAllActiveEvaluations;
}
