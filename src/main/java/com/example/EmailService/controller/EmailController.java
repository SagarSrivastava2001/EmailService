package com.example.EmailService.controller;

import com.example.EmailService.model.EmailRequest;
import com.example.EmailService.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    @Autowired
    private EmailSenderService emailSenderService;

    @PostMapping("/sendEmail")
    public ResponseEntity<Object> sendEmail(@RequestBody EmailRequest emailRequest){
        try{
            emailSenderService.sendSimpleEmail(emailRequest.getToEmail(), emailRequest.getBody(), emailRequest.getSubject());
            return ResponseEntity.ok("Email sent successfully!");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email: " + e.getMessage());
        }
    }
}
