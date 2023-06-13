package com.restaurante.dsi.service;

import java.util.List;

import com.restaurante.dsi.model.OrderDetails;

public interface IOrderDetailService {
  public List<OrderDetails> findAll();

  public OrderDetails save(OrderDetails orderDetail);
}
