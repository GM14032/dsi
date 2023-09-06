package com.restaurante.dsi.service.businesslogic;

import com.restaurante.dsi.model.businesslogic.Inventory;
import java.util.List;

public interface IInventoryService {
    public List<Inventory> findAll(Boolean active);
    Inventory save(Inventory inventory);
    Inventory update(Inventory currentInventory,Inventory inventory);
    Inventory findById(Long id);
}
