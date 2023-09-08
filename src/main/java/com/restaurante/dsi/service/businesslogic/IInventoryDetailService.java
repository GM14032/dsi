package com.restaurante.dsi.service.businesslogic;

import com.restaurante.dsi.model.businesslogic.InventoryDetail;
import com.restaurante.dsi.model.businesslogic.InventoryDetailDto;

import java.util.List;

public interface IInventoryDetailService {
    public List<InventoryDetail> getAll();
    InventoryDetail save(InventoryDetail inventoryDetail);
    InventoryDetail update(InventoryDetail currentInventoryDetail,InventoryDetail inventoryDetail);
    List<InventoryDetail> findByInventory(Long id);
    InventoryDetail findById(Long id);
    void delete(Long id);
    List<InventoryDetailDto> getInventoryDetail(Long inventoryId);

}
