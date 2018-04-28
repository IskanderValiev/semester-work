package ru.isko.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * created by Iskander Valiev
 * on 28.04.2018
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */
@Configuration
public class MailSenderConfig {

    @Autowired
    private Environment environment;

    @Bean
    public JavaMailSender javaMailSender(){

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.environment.getProperty("mail.host"));
        mailSender.setPort(Integer.parseInt(this.environment.getProperty("mail.port")));
        mailSender.setUsername(this.environment.getProperty("mail.username"));
        mailSender.setPassword(this.environment.getProperty("mail.password"));
        mailSender.setProtocol(this.environment.getProperty("mail.protocol"));

        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.starttls.enable", this.environment.getProperty("mail.smtp.starttls.enable"));
        javaMailProperties.put("mail.smtp.allow8bitmime", this.environment.getProperty("mail.smtp.allow8bitmime"));
        javaMailProperties.put("mail.smtp.ssl.trust", this.environment.getProperty("mail.smtp.ssl.trust"));
        javaMailProperties.put("mail.smtp.auth", this.environment.getProperty("mail.smtp.auth"));
        javaMailProperties.put("mail.debug", this.environment.getProperty("mail.debug"));

        mailSender.setJavaMailProperties(javaMailProperties);
        return mailSender;

    }

}
