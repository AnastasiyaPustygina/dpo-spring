package com.polytech.courses.dpo_spring.repository;

import com.polytech.courses.dpo_spring.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {}
