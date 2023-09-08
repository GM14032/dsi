package com.restaurante.dsi.repository.businesslogic;

import com.restaurante.dsi.model.businesslogic.InventoryDetail;
import com.restaurante.dsi.model.businesslogic.InventoryDetailDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IInventoryDetailRepository extends JpaRepository<InventoryDetail, Long>{
    List<InventoryDetail> findByInventoryIdOrderByIdDesc(Long inventoryId);
 @Query(value = "SELECT * from get_inventory_details(?)", nativeQuery = true)
    List<InventoryDetailDto> getInventoryDetail(Long inventoryId);

}
