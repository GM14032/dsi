package com.restaurante.dsi.repository.businesslogic;

import com.restaurante.dsi.model.businesslogic.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInventoryRepository extends JpaRepository<Inventory,Long> {
}
