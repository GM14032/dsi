package com.restaurante.dsi.controller;

import com.restaurante.dsi.model.Order;
import com.restaurante.dsi.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/orders")
public class OrderRestController {
@Autowired
    private IOrderService orderService;

    @GetMapping({ "/", "" })
    public List<Order> index() {
        return orderService.findAll();
    }
    @PostMapping("/")
    public Order register(@RequestBody Order order) {
        return orderService.save(order);
    }
    @PutMapping("/{id}")
    public Order update(@PathVariable Long id, @RequestBody Order order) {
        Order currOrder=orderService.findById(id);
        return orderService.update(currOrder,order);
    }
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.findById(id);
    }

}
