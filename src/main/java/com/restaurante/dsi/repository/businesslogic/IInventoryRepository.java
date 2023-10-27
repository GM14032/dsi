package com.restaurante.dsi.repository.businesslogic;

import com.restaurante.dsi.model.businesslogic.Inventory;
import com.restaurante.dsi.model.businesslogic.InventoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IInventoryRepository extends JpaRepository<Inventory,Long> {
    List<Inventory> findByIsActiveTrue();
    List<Inventory> findAllByOrderByIdDesc();

    @Query(value = "SELECT * from CheckInventory()", nativeQuery = true)
    List<InventoryDto> getInventoryReport();
}
