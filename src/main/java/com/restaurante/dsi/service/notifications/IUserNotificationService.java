package com.restaurante.dsi.service.notifications;

import com.restaurante.dsi.model.auth.User;
import com.restaurante.dsi.model.notifications.Notification;

public interface IUserNotificationService {
    public void update(Notification notification,User user);
}
