package com.rajan.email_service.service;

import com.rajan.email_service.helper.Message;

import java.io.File;
import java.io.InputStream;
import java.util.List;

public interface EmailService {

    // send email to single person
    void sendEmail(String to, String subject, String message);

    //send Email To Multiple Person
    void sendEmail(String []to, String subject, String message);

    //send Email with htmlContent
    void sendEmailWithHtml(String to, String subject, String message);

    //send email with file
    void sendEmailWithFile(String to, String subject, String message, File file);

    //send email with inputstream
    void sendEmailWithFile(String to, String subject, String message, InputStream is);

    List<Message> getInboxMessage();

}
