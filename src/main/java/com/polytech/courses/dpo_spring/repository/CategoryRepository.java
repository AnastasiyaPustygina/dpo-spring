package com.polytech.courses.dpo_spring.repository;

import com.polytech.courses.dpo_spring.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {}
