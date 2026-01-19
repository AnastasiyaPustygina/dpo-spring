package com.polytech.courses.dpo_spring.controller;

import com.polytech.courses.dpo_spring.dto.CourseEnrollmentRequest;
import com.polytech.courses.dpo_spring.entity.Course;
import com.polytech.courses.dpo_spring.service.CourseService;
import com.polytech.courses.dpo_spring.service.EmailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
public class CourseEnrollmentController {

    private final EmailService emailService;
    private final CourseService courseService;

    public CourseEnrollmentController(
            EmailService emailService,
            CourseService courseService
    ) {
        this.emailService = emailService;
        this.courseService = courseService;
    }

    @PostMapping("/{id}/enroll")
    public void enroll(
            @PathVariable Long id,
            @RequestBody CourseEnrollmentRequest request
    ) {
        Course course = courseService.getById(id);

        emailService.sendEnrollmentEmail(
                request.getEmail(),
                course.getTitle(),
                request
        );
    }
    @GetMapping("/test-mail")
    public void testMail() {
        emailService.sendTestEmail("pustygina.nastya@ya.ru");
    }

    @GetMapping("/admin-mail/{title}")
    public void adminMail(@PathVariable String title,
            @RequestBody CourseEnrollmentRequest request) {
        emailService.sendEnrollmentEmailToAdmin(title, request);
    }

}
