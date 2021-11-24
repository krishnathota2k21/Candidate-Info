package com.ivispl.candidate.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Objects;

/**
 * this is a mailing service.
 */
@Service
public class MailService {

    private final JavaMailSender javaMailSender;

    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    /**
     * this method sends an email with simple message.
     * @param email email address to whom this message should be delivered.
     */
    public void sendEmail(String email) {
        SimpleMailMessage mail = new SimpleMailMessage();
//        mail.setFrom("");
//        mail.setTo("krishna.thota2k21@gmail.com");
        mail.setFrom("no-reply@ivispl.com"); // read it from properties file.
        mail.setTo(email);
        mail.setSubject("Account activation - IVISPL.");
        mail.setText("Hurray! you have done that.");

        javaMailSender.send(mail);
    }

    /**
     * this method send an email with an attachment.
     * @param email email address to whom this message should be delivered.
     * @throws MessagingException this exception thrown when the multipart is failed.
     */
    public void sendEmailWithAnAttachment(String email) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setTo(email);
        helper.setSubject("Testing Mail API with Attachment");
        helper.setText("Please find the attached document below.");
        ClassPathResource classPathResource = new ClassPathResource("Attachment.pdf");
        helper.addAttachment(Objects.requireNonNull(classPathResource.getFilename()), classPathResource);

        javaMailSender.send(mimeMessage);
    }
}
