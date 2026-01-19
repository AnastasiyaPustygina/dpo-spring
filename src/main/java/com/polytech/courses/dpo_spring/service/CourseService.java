package com.polytech.courses.dpo_spring.service;

import com.polytech.courses.dpo_spring.entity.Course;
import com.polytech.courses.dpo_spring.exception.CourseNotFoundException;
import com.polytech.courses.dpo_spring.repository.CourseRepository;
import com.polytech.courses.dpo_spring.repository.CourseSpecification;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public List<Course> getAll() {
        return repository.findAll();
    }

    public Course getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new CourseNotFoundException("Course not found with id " + id));

    }

    public List<Course> searchCourses(
            String query,
            Long categoryId,
            Long teacherId,
            String sortBy,
            boolean ascending
    ) {
        Specification<Course> titleOrTagSpec = CourseSpecification.titleContains(query)
                .or(CourseSpecification.tagNameContains(query));

        Specification<Course> otherSpec = CourseSpecification.categoryEquals(categoryId)
                .and(CourseSpecification.teacherEquals(teacherId));

        Specification<Course> finalSpec = titleOrTagSpec.and(otherSpec);

        Sort sort = Sort.by(ascending ? Sort.Direction.ASC : Sort.Direction.DESC,
                sortBy == null ? "startDate" : sortBy);

        return repository.findAll(finalSpec, sort);
    }


    public List<Course> getByCourseTitle(String courseTitle) {
        return repository.findByTitle(courseTitle);
    }
}
