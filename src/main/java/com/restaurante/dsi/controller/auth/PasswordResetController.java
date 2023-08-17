package com.restaurante.dsi.controller.auth;

import com.restaurante.dsi.model.auth.PasswordResetConfirmation;
import com.restaurante.dsi.model.auth.User;
import com.restaurante.dsi.security.*;
import com.restaurante.dsi.service.auth.IUserService;
import com.restaurante.dsi.service.auth.PasswordResetService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/reset-password")
@Tag(name = "password-reset", description = "Endpoints para reestablecer contraseña")
public class PasswordResetController {

    private JwtTokenService tokenService;
    private PasswordResetService resetService;
    @Autowired
    private IUserService userService;
    @Autowired
    public PasswordResetController(JwtTokenService tokenService, PasswordResetService resetService) {
        this.tokenService = tokenService;
        this.resetService = resetService;
    }

    @PostMapping
    public ResponseEntity<String> requestPasswordReset(@RequestBody User request) {
        User user = userService.findByEmail(request.getEmail());

        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        try {
            resetService.sendPasswordResetEmail(user);
            user.setHasToken(true);
            userService.save(user);
            return ResponseEntity.ok("Password reset email sent.");
        } catch (MessagingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send reset email.");
        }
    }

    @PostMapping("/validate")
    public ResponseEntity<String> validateToken(@RequestBody PasswordResetConfirmation confirmation) {
        String token = confirmation.getToken();
        String password = confirmation.getPassword();

        Long userId = tokenService.getUserIdFromToken(token);
        if (userId == null) {
            return ResponseEntity.badRequest().body("Token invalido.");
        }

        User user = userService.findById(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        if(!user.getHasToken()){
            return ResponseEntity.badRequest().body("Token invalido.");
        }

        return ResponseEntity.ok("Token valido.");
    }
    @PostMapping("/confirm")
    public ResponseEntity<String> confirmPasswordReset(@RequestBody PasswordResetConfirmation confirmation) {
        String token = confirmation.getToken();
        String password = confirmation.getPassword();

        Long userId = tokenService.getUserIdFromToken(token);
        if (userId == null) {
            return ResponseEntity.badRequest().body("Token invalido.");
        }

        User user = userService.findById(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        if(password!=null){
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(password));
        }
        user.setHasToken(false);
        userService.save(user);
        return ResponseEntity.ok("Contraseña reestablecida.");
    }
}
