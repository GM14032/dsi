package com.restaurante.dsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurante.dsi.model.OrderDetails;

@Repository
public interface IOrderDetailRepository extends JpaRepository<OrderDetails, Long> {
}
