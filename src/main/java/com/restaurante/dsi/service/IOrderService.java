package com.restaurante.dsi.service;

import com.restaurante.dsi.model.Order;

import java.util.List;

public interface IOrderService {
    List<Order> findAll();
    Order save(Order order);
    Order update(Order currentOrder,Order order);
    Order findById(Long id);
}
