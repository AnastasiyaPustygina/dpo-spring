package com.polytech.courses.dpo_spring.dto.mapper;

import com.polytech.courses.dpo_spring.dto.*;
import com.polytech.courses.dpo_spring.entity.*;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CourseMapper {

    public CourseShortDto toShortDto(Course course) {
        return CourseShortDto.builder()
                .id(course.getId())
                .title(course.getTitle())
                .shortDescription(course.getShortDescription())
                .durationHours(course.getDurationHours())
                .categoryName(course.getCategory().getName())
                .build();
    }

    public CourseDto toDto(Course course) {
        return CourseDto.builder()
                .id(course.getId())
                .title(course.getTitle())
                .shortDescription(course.getShortDescription())
                .fullDescription(course.getFullDescription())
                .durationHours(course.getDurationHours())
                .startDate(course.getStartDate())
                .category(toCategoryDto(course.getCategory()))
                .teachers(course.getTeachers().stream()
                        .map(this::toTeacherDto)
                        .collect(Collectors.toSet()))
                .tags(course.getTags().stream()
                        .map(this::toTagDto)
                        .collect(Collectors.toSet()))
                .textAnalysis(toTextAnalysisDto(course.getTextAnalysisResult()))
                .build();
    }

    private CategoryDto toCategoryDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }

    private TeacherDto toTeacherDto(Teacher teacher) {
        return TeacherDto.builder()
                .id(teacher.getId())
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastName())
                .polytechProfileUrl(teacher.getPolytechProfileUrl())
                .build();
    }

    private CourseTagDto toTagDto(CourseTag tag) {
        return CourseTagDto.builder()
                .id(tag.getId())
                .name(tag.getName())
                .frequency(tag.getFrequency())
                .build();
    }

    private TextAnalysisResultDto toTextAnalysisDto(TextAnalysisResult result) {
        if (result == null) return null;
        return TextAnalysisResultDto.builder()
                .totalWords(result.getTotalWords())
                .uniqueWords(result.getUniqueWords())
                .language(result.getLanguage())
                .build();
    }
}
