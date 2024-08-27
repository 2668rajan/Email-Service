package com.rajan.email_service;

import com.rajan.email_service.helper.Message;
import com.rajan.email_service.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.List;

@SpringBootTest
public class EmailSenderTest {

    @Autowired
    private EmailService emailService;

    @Test
    void emailSendTest(){
        System.out.println("sending email...");
        emailService.sendEmail("user.rajan@yopmail.com",
                "Testing email service spring boot application",
                "This email is sent using spring boot application while creating a email service\n kya hal chal badmaswi 🤣 🙆‍♂️"
                );
    }

    @Test
    void sendToMultiples(){
        System.out.println("sending email to multiple persons ...");
        String []str = {"jharajan649@gmail.com", "jhatwinkle649@gmail.com", "rajan725268@gmail.com"};
        emailService.sendEmail(str, "Testing email service spring boot application",
                "This email is sent using spring boot application while creating a email service to multiple persons at a time"
        );
    }

    @Test
    void sendHtmlInEmail(){
        String html = "" +
                "<h1 style ='color:red; border:1px solid red;'>Welcome to Email service using Spring boot Application</h1>" +
                "";

        emailService.sendEmailWithHtml("jharajan649@gmail.com",
                "Testing email service spring boot application",
                html);
    }

    @Test
    void sendEmailWithFile(){

        emailService.sendEmailWithFile("jharajan649@gmail.com", "Testing email service spring boot application",
                "This email is sent using spring boot application while creating a email service to multiple persons at a time",
                    new File("C:\\Users\\2141933\\OneDrive - Cognizant\\Desktop\\Spring Boot Project\\email-service\\src\\main\\resources\\static\\images\\img.png"));
    }


    @Test
    void sendEmailWithFileWithStream(){
        File file =
                new File("C:\\Users\\2141933\\OneDrive - Cognizant\\Desktop\\Spring Boot Project\\email-service\\src\\main\\resources\\static\\images\\img.png");

        try {
            InputStream is = new FileInputStream(file);
            emailService.sendEmailWithFile("jharajan649@gmail.com",
                    "Testing email service spring boot application",
                    "This email is sent using spring boot application while creating" +
                            " a email service to multiple persons at a time", is);
        }
        catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    //receiving mail in inbox
    @Test
    void getInbox(){
        List<Message> inboxMessage = emailService.getInboxMessage();

        inboxMessage.forEach(message -> {
            System.out.println(message.getSubject());
            System.out.println(message.getContent());
            System.out.println(message.getFiles());
            System.out.println("--------------------");
        });
    }
}
