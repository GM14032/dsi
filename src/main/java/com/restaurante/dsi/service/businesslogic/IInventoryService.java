package com.restaurante.dsi.service.businesslogic;

import com.restaurante.dsi.model.businesslogic.Inventory;
import com.restaurante.dsi.model.businesslogic.InventoryDto;
import jakarta.mail.MessagingException;

import java.util.List;

public interface IInventoryService {
    public List<Inventory> findAll(Boolean active);
    Inventory save(Inventory inventory);
    Inventory update(Inventory currentInventory,Inventory inventory);
    Inventory findById(Long id);
    void sendInventoryReport(byte[] pdfBytes, String email) throws MessagingException;
    List<InventoryDto> getInventoryReport();
}
