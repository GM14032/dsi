package com.restaurante.dsi.service.businesslogic;

import com.restaurante.dsi.model.businesslogic.InventoryDetail;
import java.util.List;

public interface IInventoryDetailService {
    public List<InventoryDetail> getAll();
    InventoryDetail save(InventoryDetail inventoryDetail);
    InventoryDetail update(InventoryDetail currentInventoryDetail,InventoryDetail inventoryDetail);
    InventoryDetail findById(Long id);
    void delete(Long id);

}