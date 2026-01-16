package com.polytech.courses.dpo_spring.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
public class CourseDto {

    private final Long id;
    private final String title;
    private final String shortDescription;
    private final String fullDescription;
    private final Integer durationHours;
    private final LocalDate startDate;

    private final CategoryDto category;
    private final Set<TeacherDto> teachers;
    private final Set<CourseTagDto> tags;
    private final TextAnalysisResultDto textAnalysis;
}
