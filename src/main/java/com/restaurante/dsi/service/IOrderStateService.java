package com.restaurante.dsi.service;

import java.util.List;

import com.restaurante.dsi.model.OrderStates;

public interface IOrderStateService {
  public List<OrderStates> findAll();
}
