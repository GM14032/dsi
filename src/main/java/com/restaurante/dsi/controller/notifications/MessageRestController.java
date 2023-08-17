package com.restaurante.dsi.controller.notifications;

import com.restaurante.dsi.security.JwtUtils;
import com.restaurante.dsi.utils.Message;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/message")
@Tag(name = "Websocket", description = "Endpoints para el envio de msj del websocket")
public class MessageRestController {

  private JwtUtils jwt;
  @Autowired
  private SimpMessagingTemplate template;
  @PostMapping("/send")
  public ResponseEntity<String> sendMessage(@RequestBody Message message) {
    List<String> roles = message.getRoles();
    Map<String, String> map = new HashMap<>();
    map.put("message", message.getContent());
    map.put("idNotification",message.getIdNotification().toString());
    for (String role : roles) {
      template.convertAndSend("/topic/message/" + role, map);
    }
    return ResponseEntity.ok("Message sent!");
  }
}
