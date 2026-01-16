package com.polytech.courses.dpo_spring.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class CourseShortDto {
    private final Long id;
    private final String title;
    private final String shortDescription;
    private final Integer durationHours;
    private final String categoryName;
}
