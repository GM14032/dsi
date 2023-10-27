package com.restaurante.dsi.repository.businesslogic;

import com.restaurante.dsi.model.businesslogic.Order;
import com.restaurante.dsi.model.businesslogic.OrderDto;
import com.restaurante.dsi.model.notifications.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCreateAtBetweenOrderByCreateAtDesc(LocalDateTime startDate, LocalDateTime endDate);
    List<Order> findAllByOrderByCreateAtDesc();
    @Query(value = "SELECT insert_inventory_detail_function(?)", nativeQuery = true)
    void updateInventoryFuntion(Long id);

    @Query(value = "SELECT to_char(create_at,  'TMMonth') AS month,\n" +
            "       SUM(total) AS total,COUNT(*) AS quantity FROM orders\n" +
            "WHERE create_at > NOW() - INTERVAL '5 months'\n" +
            "GROUP BY to_char(create_at, 'MM'), month\n" +
            "ORDER BY to_char(create_at, 'MM');", nativeQuery = true)
    List<OrderDto> getOrdersByMonth();


}
