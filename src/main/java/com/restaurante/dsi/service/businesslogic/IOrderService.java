package com.restaurante.dsi.service.businesslogic;

import com.restaurante.dsi.model.businesslogic.Order;
import jakarta.mail.MessagingException;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface IOrderService {
    public List<Order> findAll(LocalDate startDate, LocalDate endDate );
    Order save(Order order);
    Order update(Order currentOrder,Order order);
    Order findById(Long id);
    void sendInvoice(byte[] pdfBytes, String email) throws MessagingException;
}
