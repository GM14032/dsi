package com.restaurante.dsi.service.notifications;

import com.restaurante.dsi.model.auth.User;
import com.restaurante.dsi.model.notifications.Notification;
import com.restaurante.dsi.repository.notifications.IUserNotificationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserNotificationsImpl implements IUserNotificationService{
    @Autowired
    private IUserNotificationRepository userNotificationRepository;
    @Override
    @Transactional
    public void update(Notification notification,User user) {
        userNotificationRepository.userNotification(notification,user,true);

    }
}
