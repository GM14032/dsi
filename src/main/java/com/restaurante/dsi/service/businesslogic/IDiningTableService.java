package com.restaurante.dsi.service.businesslogic;

import com.restaurante.dsi.model.businesslogic.DiningTable;

import java.util.List;

public interface IDiningTableService {

  public List<DiningTable> findAll();
  public DiningTable save(DiningTable table);
  public DiningTable update(DiningTable currentTable, DiningTable table);
  public DiningTable findById(Long id);
  public void delete(Long id);
    
} 
