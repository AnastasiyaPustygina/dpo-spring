package com.polytech.courses.dpo_spring.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CourseTagDto {

    private final Long id;
    private final String name;
    private final Integer frequency;
}
