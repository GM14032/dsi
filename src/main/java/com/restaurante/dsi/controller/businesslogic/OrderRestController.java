package com.restaurante.dsi.controller.businesslogic;

import com.restaurante.dsi.model.businesslogic.Order;
import com.restaurante.dsi.service.businesslogic.IOrderDetailService;
import com.restaurante.dsi.service.businesslogic.IOrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/orders")
@Tag(name = "ordenes", description = "Endpoints para las ordenes")
public class OrderRestController {
    @Autowired
    private IOrderService orderService;

    @Autowired
    private IOrderDetailService orderDetailService;

    @GetMapping({ "/", "" })
    public List<Order> index(
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate
    ) {
        return orderService.findAll(startDate,endDate);
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
