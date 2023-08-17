package com.restaurante.dsi.repository.notifications;

import com.restaurante.dsi.model.notifications.UserNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IUserNotificationRepository extends JpaRepository<UserNotification, Long> {

}
