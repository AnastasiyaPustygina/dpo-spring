package com.polytech.courses.dpo_spring.repository;

import com.polytech.courses.dpo_spring.entity.Course;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;

public class CourseSpecification {

    public static Specification<Course> titleContains(String title) {
        return (root, query, cb) ->
                title == null ? null : cb.like(cb.lower(root.get("title")), "%" + title.toLowerCase() + "%");
    }

    public static Specification<Course> categoryEquals(Long categoryId) {
        return (root, query, cb) ->
                categoryId == null ? null : cb.equal(root.get("category").get("id"), categoryId);
    }

    public static Specification<Course> teacherEquals(Long teacherId) {
        return (root, query, cb) -> {
            if (teacherId == null) return null;
            return cb.equal(root.join("teachers", JoinType.LEFT).get("id"), teacherId);
        };
    }

    public static Specification<Course> tagsIn(Long[] tagIds) {
        return (root, query, cb) -> {
            if (tagIds == null || tagIds.length == 0) return null;
            return root.join("tags", JoinType.LEFT).get("id").in((Object[]) tagIds);
        };
    }
    public static Specification<Course> tagNameContains(String tagName) {
        return (root, query, cb) -> {
            if (tagName == null) return null;
            return cb.like(cb.lower(root.join("tags", JoinType.LEFT).get("name")), "%" + tagName.toLowerCase() + "%");
        };
    }

}
