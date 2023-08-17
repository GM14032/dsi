package com.restaurante.dsi.repository.notifications;

import com.restaurante.dsi.model.auth.User;
import com.restaurante.dsi.model.notifications.Notification;
import com.restaurante.dsi.model.notifications.NotificationDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface INotificationRepository extends JpaRepository<Notification,Long> {
    @Query("SELECT n FROM Notification n ORDER BY n.createAt DESC")
    public List<Notification> findAllSortedByDateDesc();

    @Query("SELECT n.id as id, n.message as message, n.createAt as createAt, un.status as status, un.users.id as userId " +
            "FROM Notification n INNER JOIN UserNotification un ON un.notification = n.id " +
            "WHERE un.users = :userId ORDER BY n.createAt DESC")
    List<NotificationDTO> findByUser(User userId);

}
