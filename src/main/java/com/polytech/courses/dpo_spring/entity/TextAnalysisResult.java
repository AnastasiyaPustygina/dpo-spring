package com.polytech.courses.dpo_spring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "text_analysis_results")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TextAnalysisResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer totalWords;
    private Integer uniqueWords;
    private String language;

    private Instant analyzedAt;

    @OneToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
