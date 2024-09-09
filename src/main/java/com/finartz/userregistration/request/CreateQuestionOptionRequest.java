package com.finartz.userregistration.request;

import com.finartz.userregistration.entity.OptionEnum;

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
    private OptionEnum optionEnum;
    private Boolean isMandatory;
    private Boolean isHidden;
}
