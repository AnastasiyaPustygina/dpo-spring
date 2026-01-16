package com.polytech.courses.dpo_spring.controller;

import com.polytech.courses.dpo_spring.dto.TeacherDto;
import com.polytech.courses.dpo_spring.dto.mapper.TeacherMapper;
import com.polytech.courses.dpo_spring.entity.Teacher;
import com.polytech.courses.dpo_spring.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService service;
    private final TeacherMapper mapper;


    @GetMapping
    public List<TeacherDto> getTeachers() {
        return service.getAll().stream().map(mapper::toDto).toList();
    }

    @GetMapping("/{id}")
    public TeacherDto getTeacher(@PathVariable Long id) {
        Teacher teacher = service.getById(id);
        return mapper.toDto(teacher);
    }
}
