package com.polytech.courses.dpo_spring.controller;

import com.polytech.courses.dpo_spring.dto.CourseDto;
import com.polytech.courses.dpo_spring.dto.CourseShortDto;
import com.polytech.courses.dpo_spring.dto.mapper.CourseMapper;
import com.polytech.courses.dpo_spring.entity.Course;
import com.polytech.courses.dpo_spring.exception.CourseNotFoundException;
import com.polytech.courses.dpo_spring.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService service;
    private final CourseMapper mapper;

    public CourseController(CourseService service, CourseMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<CourseShortDto> getCourses(
            @RequestParam(required = false) String query,
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) Long teacherId,
            @RequestParam(required = false) String sortBy,
            @RequestParam(defaultValue = "true") boolean ascending
    ) {
        List<Course> courses = service.searchCourses(query, categoryId, teacherId, sortBy, ascending);
        return courses.stream().map(mapper::toShortDto).collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    public CourseDto getCourse(@PathVariable Long id) {
        Course course = service.getById(id);
        return mapper.toDto(course);
    }
}
