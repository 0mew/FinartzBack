package com.finartz.userregistration.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MailTemplateResponse {

    private Long id;
    private String title;
    private String description;
    private Boolean updateAllActiveEvaluations;
}



