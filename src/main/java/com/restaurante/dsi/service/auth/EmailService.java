package com.restaurante.dsi.service.auth;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

@Service
public class EmailService {
    private JavaMailSender mailSender;

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    public void sendEmail(String to, String subject, String body, String name) throws MessagingException {
        sendEmail(to, subject, body, name, null, null, null);
    }


    public void sendEmail(String to, String subject, String body,String name,byte[] pdfBytes,String pdfName,String[] cc) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(to);
        try {
            helper.setFrom(new InternetAddress(to, MimeUtility.encodeText(name, "UTF-8", "B")));
        } catch (UnsupportedEncodingException e) {
            helper.setFrom(new InternetAddress(to));
        }
        if (cc != null && cc.length > 0){
            helper.setCc(cc);
        }
        helper.setSubject(subject);
        helper.setText(body, true);
        if(pdfBytes!=null){
            helper.addAttachment(pdfName, new ByteArrayResource(pdfBytes));
        }

        mailSender.send(message);
    }
    }

