package com.smtp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.TestPropertySource;

import java.util.Properties;

@SpringBootTest
@TestPropertySource("classpath:properties/smtp.properties")
public class SmtpTests {
    @Value("${smtp.host}")
    String host;
    @Value("${smtp.port}")
    int port;
    @Value("${smtp.username}")
    String username;
    @Value("${smtp.password}")
    String password;

    @Test
    public void smtpTest() {


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
