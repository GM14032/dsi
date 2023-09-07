package com.restaurante.dsi.repository.businesslogic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.restaurante.dsi.model.businesslogic.DiningTable;
import java.util.List;

@Repository
public interface IDiningTableRepository extends JpaRepository<DiningTable, Long>{
    List<DiningTable> findByAvailable(Boolean available);
} 