package com.smtp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@SpringBootTest
public class SmtpTests {

    @Test
    public void smtpTest() {
        String host = "smtp.gmail.com";
        int port = 587;
        String username = "dks2922@gmail.com";
        String password = "bjknfoiuqcntmngv";

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(username);
        mailSender.setPassword(password);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.starttls.required", "true");
        props.put("mail.smtp.ssl.trust", host);

        SimpleMailMessage message = new SimpleMailMessage();

        message.setSubject("회원가입을 진심으로 축하합니다.");
        message.setText("환영합니다.!!");
        message.setFrom("dks2922@gmail.com");
        message.setTo("dks2922@gmail.com");

        mailSender.send(message);
    }
}
