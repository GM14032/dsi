package com.restaurante.dsi.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/message")
public class MessageRestController {

  @Autowired
  private SimpMessagingTemplate template;

  @GetMapping({ "/send", "/send/" })
  public ResponseEntity<String> index() {
    Map<String, String> map = new HashMap<>();
    map.put("message", "Hello, world!");
    template.convertAndSend("/topic/message", map); // enviamos la notificacion
    return ResponseEntity.ok("Message sent!");
  }
}
