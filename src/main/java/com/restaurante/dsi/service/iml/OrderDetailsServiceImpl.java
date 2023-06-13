package com.restaurante.dsi.service.iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.dsi.model.OrderDetails;
import com.restaurante.dsi.repository.IOrderDetailRepository;
import com.restaurante.dsi.service.IOrderDetailService;

@Service
public class OrderDetailsServiceImpl implements IOrderDetailService {

  @Autowired
  private IOrderDetailRepository orderDetailRepository;

  @Override
  public List<OrderDetails> findAll() {
    return orderDetailRepository.findAll();
  }

  @Override
  public OrderDetails save(OrderDetails orderDetail) {
    return orderDetailRepository.save(orderDetail);
  }
}
