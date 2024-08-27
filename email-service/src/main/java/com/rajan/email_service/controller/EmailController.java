package com.rajan.email_service.controller;

import com.rajan.email_service.helper.CustomResponse;
import com.rajan.email_service.request.EmailRequest;
import com.rajan.email_service.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin("*")
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello!";
    }

    @PostMapping("/send")
    public ResponseEntity<CustomResponse> sendEmail(@RequestBody EmailRequest emailRequest){
        emailService.sendEmailWithHtml(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getMessage());
        return ResponseEntity.ok(
                CustomResponse.builder()
                        .message("Email sent successfully!")
                        .httpStatus(HttpStatus.OK)
                        .success(true)
                        .build()
        );
    }

    @PostMapping("/send-with-file")
    public ResponseEntity<CustomResponse> sendEmailWithFile(@RequestPart EmailRequest emailRequest,
                                                            @RequestPart MultipartFile file) throws IOException {
        emailService.sendEmailWithFile(emailRequest.getTo(), emailRequest.getSubject(),
                emailRequest.getMessage(), file.getInputStream());

        return ResponseEntity.ok(
                CustomResponse.builder()
                        .message("Email sent successfully!")
                        .httpStatus(HttpStatus.OK)
                        .success(true)
                        .build()
        );
    }
}
