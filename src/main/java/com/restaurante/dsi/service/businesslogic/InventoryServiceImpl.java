package com.restaurante.dsi.service.businesslogic;

import com.restaurante.dsi.model.businesslogic.Inventory;
import com.restaurante.dsi.repository.businesslogic.IInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements IInventoryService {
    @Autowired
    private IInventoryRepository inventoryRepository;
    @Override
    public List<Inventory> findAll( Boolean active) {
        if (active != null && active) {
            return inventoryRepository.findByIsActiveTrue();
        }
        return inventoryRepository.findAllByOrderByIdDesc();
    }

    @Override
    public Inventory save(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public Inventory update(Inventory currentInventory, Inventory inventory) {
      return inventoryRepository.save(currentInventory);
    }

    @Override
    public Inventory findById(Long id) {
        return inventoryRepository.findById(id).orElse(null);
    }
}