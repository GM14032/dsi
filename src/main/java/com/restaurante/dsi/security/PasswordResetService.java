package com.restaurante.dsi.security;

import com.restaurante.dsi.model.User;
import com.restaurante.dsi.service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

@Service
public class PasswordResetService {
    private JwtTokenService tokenService;
    @Autowired
    private EmailService emailService;

    @Autowired
    public PasswordResetService(JwtTokenService tokenService, EmailService emailService) {
        this.tokenService = tokenService;
        this.emailService = emailService;
    }

    public void sendPasswordResetEmail(User user) throws MessagingException {
        String token = tokenService.generateToken(user);
        String resetUrl = "http://localhost:3000/auth/reset-password?token=" + token;
        String name = "Restaurante DSI";
        String subject = "Restablecer tu contraseña";
        String body = "Haga clic en el enlace para restablecer su contraseña:\n" + resetUrl;

        emailService.sendEmail(user.getEmail(), subject, body,name);
    }
}
