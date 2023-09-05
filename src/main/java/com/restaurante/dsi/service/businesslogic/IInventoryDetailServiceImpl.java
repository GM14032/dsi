package com.restaurante.dsi.service.businesslogic;

import com.restaurante.dsi.model.businesslogic.InventoryDetail;
import com.restaurante.dsi.repository.businesslogic.IInventoryDetailRepository;
import com.restaurante.dsi.repository.businesslogic.IInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IInventoryDetailServiceImpl implements IInventoryDetailService{
    @Autowired
    private IInventoryDetailRepository inventoryDetailRepository;
    @Override
    public List<InventoryDetail> getAll() {
        return inventoryDetailRepository.findAll();
    }

    @Override
    public InventoryDetail save(InventoryDetail inventoryDetail) {
        return inventoryDetailRepository.save(inventoryDetail);
    }

    @Override
    public InventoryDetail update(InventoryDetail currentInventoryDetail, InventoryDetail inventoryDetail) {
        if (inventoryDetail.getQuantity() != null) {
            currentInventoryDetail.setQuantity(inventoryDetail.getQuantity());
        }
        if (inventoryDetail.getPrice() != null) {
            currentInventoryDetail.setPrice(inventoryDetail.getPrice());
        }
        if (inventoryDetail.getIsEntry() != null) {
            currentInventoryDetail.setIsEntry(inventoryDetail.getIsEntry());
        }
        return inventoryDetailRepository.save(currentInventoryDetail);
    }

    @Override
    public InventoryDetail findById(Long id) {
        return inventoryDetailRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {

    }
}