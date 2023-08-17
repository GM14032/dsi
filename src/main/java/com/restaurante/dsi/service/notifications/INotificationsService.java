package com.restaurante.dsi.service.notifications;

import com.restaurante.dsi.model.auth.User;
import com.restaurante.dsi.model.notifications.Notification;
import com.restaurante.dsi.model.notifications.NotificationDTO;

import java.util.List;

public interface INotificationsService {
    public List<Notification> findAll();

    public Notification save(Notification notifications);

    public List<NotificationDTO> findByUser(User user);
}
