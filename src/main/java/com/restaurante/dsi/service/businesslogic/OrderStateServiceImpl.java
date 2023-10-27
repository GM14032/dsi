package com.restaurante.dsi.service.businesslogic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.dsi.model.businesslogic.OrderState;
import com.restaurante.dsi.repository.businesslogic.IOrderStateRepository;

@Service
public class OrderStateServiceImpl implements IOrderStateService {

  @Autowired
  private IOrderStateRepository orderStatesRepository;

  @Override
  public List<OrderState> findAll() {
    return orderStatesRepository.findAll();
  }

  @Override
  public OrderState findById(Long id){
    return orderStatesRepository.findById(id).orElse(null);
  }

    @Override
    public OrderState findByName(String name){
        return orderStatesRepository.findByName(name);
    }
}
