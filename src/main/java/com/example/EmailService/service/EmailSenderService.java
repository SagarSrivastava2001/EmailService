package com.example.EmailService.service;

public interface EmailSenderService {
    void sendSimpleEmail(String toEmail, String body, String subject);
}
