package com.finartz.userregistration.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TitleRequest {
    @NotBlank
    private String title;
}
