package com.polytech.courses.dpo_spring.service;

import com.polytech.courses.dpo_spring.dto.CourseEnrollmentRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
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

