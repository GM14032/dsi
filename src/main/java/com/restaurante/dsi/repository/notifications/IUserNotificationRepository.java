package com.restaurante.dsi.repository.notifications;

import com.restaurante.dsi.model.auth.User;
import com.restaurante.dsi.model.notifications.Notification;
import com.restaurante.dsi.model.notifications.UserNotification;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface IUserNotificationRepository extends JpaRepository<UserNotification, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE UserNotification  SET status = :newStatus WHERE users = :user AND notification = :notification")
    public void userNotification( Notification notification,User user, Boolean newStatus);
}
