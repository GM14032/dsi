package com.restaurante.dsi.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter @Getter @AllArgsConstructor
public class Message {
    private String content;
    List<String> roles;
    private Long idNotification;
}
