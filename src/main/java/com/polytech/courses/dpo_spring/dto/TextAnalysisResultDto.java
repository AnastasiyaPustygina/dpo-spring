package com.polytech.courses.dpo_spring.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TextAnalysisResultDto {
    private final Integer totalWords;
    private final Integer uniqueWords;
    private final String language;

}
