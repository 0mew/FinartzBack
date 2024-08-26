package com.finartz.userregistration.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateQuestionOptionRequest {
    private Long questionId;
    private Long optionId;
    private Boolean isMandatory;
    private Boolean isHidden;
}
