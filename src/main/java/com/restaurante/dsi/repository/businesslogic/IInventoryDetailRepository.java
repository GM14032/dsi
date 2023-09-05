package com.restaurante.dsi.repository.businesslogic;

import com.restaurante.dsi.model.businesslogic.InventoryDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInventoryDetailRepository extends JpaRepository<InventoryDetail, Long>{
}
