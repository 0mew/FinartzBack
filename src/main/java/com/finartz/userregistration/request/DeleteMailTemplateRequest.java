package com.finartz.userregistration.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DeleteMailTemplateRequest {
    @NotNull
    @NotEmpty
    private Long id;
}
