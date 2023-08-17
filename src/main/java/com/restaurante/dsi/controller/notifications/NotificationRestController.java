package com.restaurante.dsi.controller.notifications;

import com.restaurante.dsi.model.auth.User;
import com.restaurante.dsi.model.notifications.Notification;
import com.restaurante.dsi.model.notifications.NotificationDTO;
import com.restaurante.dsi.service.auth.IUserService;
import com.restaurante.dsi.service.notifications.INotificationsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/notifications")
@Tag(name = "Websocket", description = "Endpoints para el envio de msj de las notificaciones de la base de datos")
public class NotificationRestController {
    @Autowired
    private INotificationsService notificationsService;

    @Autowired
    private IUserService userService;
    @GetMapping("/")
    public List<Notification> index(){
        return notificationsService.findAll();
    }
    @PostMapping("/")
    public Notification save(@RequestBody Notification notifications){
        return notificationsService.save(notifications);
    }
    @GetMapping("/{id}")
    public List<NotificationDTO> findById(@PathVariable Long id){
        User user=userService.findById(id);
        return notificationsService.findByUser(user);
    }
}
