package com.restaurante.dsi.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = { "*" })
@Controller
public class MessageController {
    @MessageMapping("/message")
    @SendTo("/topic/response")
    public ResponseMessage getMessage(final Message message) {
        return new ResponseMessage("Hello, " + message.getContent() + "!");
    }
}
