package com.restaurante.dsi.model.auth;

import lombok.*;;

@Setter @Getter @NoArgsConstructor
public class PasswordResetConfirmation {
    private String token;
    private String password;

}
