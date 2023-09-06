package com.restaurante.dsi.repository.businesslogic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurante.dsi.model.businesslogic.OrderState;

@Repository
public interface IOrderStateRepository extends JpaRepository<OrderState, Long> {
    OrderState findByName(String name);
}
