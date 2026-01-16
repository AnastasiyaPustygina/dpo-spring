package com.polytech.courses.dpo_spring.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeacherDto {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String polytechProfileUrl;


}
