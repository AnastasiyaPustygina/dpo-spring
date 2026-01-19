package com.polytech.courses.dpo_spring.service;

import com.polytech.courses.dpo_spring.dto.CourseEnrollmentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;
    private final CourseService courseEnrollService;

    public EmailService(JavaMailSender mailSender, CourseService courseEnrollService) {
        this.mailSender = mailSender;
        this.courseEnrollService = courseEnrollService;
    }

    @Async
    public void sendEnrollmentEmail(
            String to,
            String courseTitle,
            CourseEnrollmentRequest req
    ) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject("Заявка на курс: " + courseTitle);
            message.setText("""
                Вы подали заявку на курс "%s"

                ФИО: %s
                Телефон: %s
                Комментарий: %s
                """.formatted(
                    courseTitle,
                    req.getFullName(),
                    req.getPhone(),
                    req.getComment()
            ));

            mailSender.send(message);
            System.out.println("Письмо отправлено на " + to);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Async
    public void sendEnrollmentEmailToAdmin(
            String courseTitle,
            CourseEnrollmentRequest req
    ) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo("pustygina.nastya@yandex.ru");
            message.setSubject("Новая заявка на курс: " + courseTitle);
            message.setText("""
                    Получена новая заявка на курс "%s".
                    Данные заявителя:
                    ФИО: %s
                    Email: %s
                    Телефон: %s
                    Комментарий: %s
                    Всего заявок: %s
                    """.formatted(
                    courseTitle,
                    req.getFullName(),
                    req.getEmail(),
                    req.getPhone(),
                    req.getComment(),
                    courseEnrollService.getByCourseTitle(courseTitle).size())
            );

            mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Async
    public void sendTestEmail(String to) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject("Тест");
            message.setText("Почта работает");

            mailSender.send(message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

