package com.polytech.courses.dpo_spring.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CategoryDto {

    private final long id;
    private final String name;
    private final String description;

}
