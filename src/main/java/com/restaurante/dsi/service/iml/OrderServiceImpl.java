package com.restaurante.dsi.service.iml;

import com.restaurante.dsi.model.Order;
import com.restaurante.dsi.repository.IOrderRepository;
import com.restaurante.dsi.service.IOrderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("OrderService")
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    @Transactional
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order update(Order currentOrder, Order order) {
        if (order.getQuantity() != null) {
            currentOrder.setQuantity(order.getQuantity());
        }
        if (order.getCategory() != null) {
            currentOrder.setCategory(order.getCategory());
        }
        if (order.getDescription() != null) {
            currentOrder.setDescription(order.getDescription());
        }
        if (order.getState() != null) {
            currentOrder.setState(order.getState());
        }
        return orderRepository.save(currentOrder);
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
}
