package com.restaurante.dsi.service.businesslogic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.dsi.model.businesslogic.OrderDetail;
import com.restaurante.dsi.repository.businesslogic.IOrderDetailRepository;
import com.restaurante.dsi.service.businesslogic.IOrderDetailService;

@Service
public class OrderDetailsServiceImpl implements IOrderDetailService {

  @Autowired
  private IOrderDetailRepository orderDetailRepository;

  @Override
  public List<OrderDetail> findAll() {
    return orderDetailRepository.findAll();
  }

  @Override
  public OrderDetail save(OrderDetail orderDetail) {
    return orderDetailRepository.save(orderDetail);
  }
}
