package com.polytech.courses.dpo_spring.service;

import com.polytech.courses.dpo_spring.entity.Teacher;
import com.polytech.courses.dpo_spring.exception.TeacherNotFoundException;
import com.polytech.courses.dpo_spring.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository repository;

    public List<Teacher> getAll() {
        return repository.findAll();
    }

    public Teacher getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new TeacherNotFoundException("Teacher not found with id " + id));

    }

}
