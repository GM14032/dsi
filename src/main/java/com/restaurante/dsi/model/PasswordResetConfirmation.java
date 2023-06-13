package com.restaurante.dsi.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class PasswordResetConfirmation {
    private String token;
    private String password;

}
