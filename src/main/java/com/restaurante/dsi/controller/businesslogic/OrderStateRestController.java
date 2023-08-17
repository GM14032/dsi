package com.restaurante.dsi.controller.businesslogic;

import java.util.List;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.dsi.model.businesslogic.OrderState;
import com.restaurante.dsi.service.businesslogic.IOrderStateService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/order_states")
@Tag(name = "Ordenes-estado", description = "Endpoints para el estado de las ordenes")
public class OrderStateRestController {

  @Autowired
  private IOrderStateService orderStateService;

  @GetMapping({ "/", "" })
  public List<OrderState> index() {
    return orderStateService.findAll();
  }

}
