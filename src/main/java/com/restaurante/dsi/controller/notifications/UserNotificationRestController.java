package com.restaurante.dsi.controller.notifications;

import com.restaurante.dsi.model.notifications.UserNotification;
import com.restaurante.dsi.service.notifications.IUserNotificationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/usernotifications")
@Tag(name = "Notificacion", description = "Endpoints para el envio de msj de las notificaciones de la base de datos")
public class UserNotificationRestController {
@Autowired
    private IUserNotificationService userNotificationService;
    @PutMapping({"/",""})
    public void update(@RequestBody UserNotification userNotification){
        System.out.println(userNotification.getNotification().getId());
        userNotificationService.update(userNotification.getNotification(),userNotification.getUsers());

    }
}
