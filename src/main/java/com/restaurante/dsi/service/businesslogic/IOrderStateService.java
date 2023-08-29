package com.restaurante.dsi.service.businesslogic;

import java.util.List;

import com.restaurante.dsi.model.businesslogic.OrderState;

public interface IOrderStateService {
  public List<OrderState> findAll();

  public OrderState findById(Long id);
}
