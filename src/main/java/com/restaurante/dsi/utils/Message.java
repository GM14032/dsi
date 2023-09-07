package com.restaurante.dsi.utils;

import lombok.*;
import java.util.List;

@Setter @Getter @AllArgsConstructor
public class Message {
    private String content;
    List<String> roles;
    private Long idNotification;
    private String redirect;
}
