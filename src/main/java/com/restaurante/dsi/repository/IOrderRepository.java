package com.restaurante.dsi.repository;

import com.restaurante.dsi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order, Long>{
}
