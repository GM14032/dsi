package com.restaurante.dsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurante.dsi.model.OrderStates;

@Repository
public interface IOrderStatesRepository extends JpaRepository<OrderStates, Long> {

}
