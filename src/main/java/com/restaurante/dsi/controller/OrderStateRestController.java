package com.restaurante.dsi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.dsi.model.OrderStates;
import com.restaurante.dsi.service.IOrderStateService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/order_states")
public class OrderStateRestController {

  @Autowired
  private IOrderStateService orderStateService;

  @GetMapping({ "/", "" })
  public List<OrderStates> index() {
    return orderStateService.findAll();
  }

}
