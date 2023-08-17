package com.restaurante.dsi.repository.businesslogic;

import com.restaurante.dsi.model.businesslogic.Order;
import com.restaurante.dsi.model.notifications.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCreateAtBetweenOrderByCreateAtDesc(LocalDateTime startDate, LocalDateTime endDate);
    List<Order> findAllByOrderByCreateAtDesc();
}
