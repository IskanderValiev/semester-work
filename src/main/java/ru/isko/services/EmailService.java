package ru.isko.services;

<<<<<<< Updated upstream
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * created by Iskander Valiev
 * on 15.04.2018
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */
@Service
public class EmailService {

    @Autowired
    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(String text, String subject, String email) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            message.setContent(text, "text/html");
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
            messageHelper.setTo(email);
            messageHelper.setSubject(subject);
            messageHelper.setText(text, true);
        } catch (MessagingException e) {
            throw new IllegalArgumentException(e);
        }

        javaMailSender.send(message);
    }
=======
public interface EmailService {
    void sendMail(String text, String subject, String email);
>>>>>>> Stashed changes
}
