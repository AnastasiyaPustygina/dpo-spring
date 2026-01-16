package com.polytech.courses.dpo_spring.dto.mapper;

import com.polytech.courses.dpo_spring.dto.*;
import com.polytech.courses.dpo_spring.entity.*;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TeacherMapper {

    public TeacherDto toDto(Teacher teacher) {
        return TeacherDto.builder().id(teacher.getId())
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastName())
                .polytechProfileUrl(teacher.getPolytechProfileUrl()).build();
    }

}
