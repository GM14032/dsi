package com.restaurante.dsi.service.businesslogic;

import com.restaurante.dsi.model.businesslogic.Order;
import com.restaurante.dsi.repository.businesslogic.IOrderRepository;
import com.restaurante.dsi.service.auth.EmailService;
import jakarta.mail.MessagingException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service("OrderService")
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderRepository orderRepository;
    @Autowired
    private EmailService emailService;
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Order> findAll(LocalDate startDate, LocalDate endDate ) {
        if (startDate==null){
            return orderRepository.findAllByOrderByCreateAtDesc();
        }
        if (endDate == null) {
            endDate = LocalDate.now();
        }
        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.atTime(23, 59, 59);
        return orderRepository.findByCreateAtBetweenOrderByCreateAtDesc(startDateTime,endDateTime);
    }

    @Transactional
    @Override
    public Order save(Order order) {
        Order newOrder=orderRepository.save(order);
        entityManager.refresh(newOrder);
         return newOrder;
    }

    @Override
    public Order update(Order currentOrder, Order order) {
        if (order.getQuantity() != null) {
            currentOrder.setQuantity(order.getQuantity());
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

    public void sendInvoice(byte[] pdfBytes, String email) throws MessagingException {
        String name = "Restaurante DSI";
        String subject = "Factura";
        String body = "Haga clic en el archivo para descargar tu factura";
        emailService.sendEmail(email, subject, body, name, pdfBytes);
    }
}
