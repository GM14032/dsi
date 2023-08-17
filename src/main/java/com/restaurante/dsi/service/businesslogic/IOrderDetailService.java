package com.restaurante.dsi.service.businesslogic;

import java.util.List;

import com.restaurante.dsi.model.businesslogic.OrderDetail;

public interface IOrderDetailService {
  public List<OrderDetail> findAll();

  public OrderDetail save(OrderDetail orderDetail);
}
