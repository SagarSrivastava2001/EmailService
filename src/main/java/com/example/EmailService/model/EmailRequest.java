package com.example.EmailService.model;

import lombok.Data;

@Data
public class EmailRequest {
    private String toEmail;
    private String body;
    private String subject;
}
