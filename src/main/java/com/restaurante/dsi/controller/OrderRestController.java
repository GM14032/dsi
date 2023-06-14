package com.restaurante.dsi.controller;

import com.restaurante.dsi.model.Order;
import com.restaurante.dsi.model.Role;
import com.restaurante.dsi.service.IOrderDetailService;
import com.restaurante.dsi.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/orders")
public class OrderRestController {
    @Autowired
    private IOrderService orderService;

    @Autowired
    private IOrderDetailService orderDetailService;

    @GetMapping({ "/", "" })
    public List<Order> index() {
        return orderService.findAll();
    }

    @PostMapping("/")
    public Order register(@RequestBody Order order) {
        Order newOrder = orderService.save(order);
        // save each order detail
        order.getOrderDetails().forEach(orderDetail -> {
            orderDetail.setOrder(newOrder);
            orderDetailService.save(orderDetail);
        });
        newOrder.setOrderDetails(order.getOrderDetails());
        return newOrder;
    }

    @PutMapping("/{id}")
    public Order update(@PathVariable Long id, @RequestBody Order order) {
        Order currOrder = orderService.findById(id);
        return orderService.update(currOrder, order);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order order = orderService.findById(id);
if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

}
