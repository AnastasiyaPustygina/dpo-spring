package com.polytech.courses.dpo_spring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedEntityGraph(
        name = "course-full",
        attributeNodes = {
                @NamedAttributeNode("category"),
                @NamedAttributeNode("teachers"),
                @NamedAttributeNode("tags"),
                @NamedAttributeNode("textAnalysisResult")
        }
)
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String shortDescription;

    @Column(columnDefinition = "TEXT")
    private String fullDescription;

    private Integer durationHours;

    private LocalDate startDate;

    @ManyToOne
    private Category category;

    @ManyToMany
    @JoinTable(
            name = "course_teacher",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private Set<Teacher> teachers = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "course_tag_relation",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<CourseTag> tags = new HashSet<>();

    @OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
    private TextAnalysisResult textAnalysisResult;
}