package com.restaurante.dsi.service.notifications;

import com.restaurante.dsi.model.auth.User;
import com.restaurante.dsi.model.notifications.Notification;
import com.restaurante.dsi.model.notifications.NotificationDTO;
import com.restaurante.dsi.repository.notifications.INotificationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NotificationsServiceImpl implements INotificationsService {
    @Autowired
    private INotificationRepository notificationsRepository;

    @Override
    @Transactional
    public List<Notification> findAll() {
        return notificationsRepository.findAllSortedByDateDesc();
    }
    @Override
    @Transactional
    public Notification save(Notification notifications) {
        return notificationsRepository.save(notifications);
    }
    @Override
    public List<NotificationDTO> findByUser(User user) {

        return notificationsRepository.findByUser(user);
    }
}
