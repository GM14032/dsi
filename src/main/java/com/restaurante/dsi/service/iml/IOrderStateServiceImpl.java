package com.restaurante.dsi.service.iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.dsi.model.OrderStates;
import com.restaurante.dsi.repository.IOrderStatesRepository;
import com.restaurante.dsi.service.IOrderStateService;

@Service
public class IOrderStateServiceImpl implements IOrderStateService {

  @Autowired
  private IOrderStatesRepository orderStatesRepository;

  @Override
  public List<OrderStates> findAll() {
    return orderStatesRepository.findAll();
  }

}
