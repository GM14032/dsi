package com.restaurante.dsi.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.dsi.model.Tables;
import com.restaurante.dsi.repository.ITableRepository;
import com.restaurante.dsi.service.ITableService;

import jakarta.transaction.Transactional;

@Service("TablesService")
public class TableServiceImpl implements ITableService  {
    @Autowired
  private ITableRepository tableRepository;

  @Override
  public List<Tables> findAll() {
    return tableRepository.findAll();
  }

  @Override
  @Transactional
  public Tables save(Tables table) {
      return tableRepository.save(table);

  }

   @Override
    @Transactional
    public Tables update(Tables currentTable, Tables table) {

            if(table.getCapacity()!=null){
                currentTable.setCapacity(table.getCapacity());
            }
            if(table.getDescription()!=null){
                currentTable.setDescription(table.getDescription());
            }
            return tableRepository.save(currentTable);

    }
  @Override
  public Tables findById(Long id) {
    return tableRepository.findById(id).orElse(null)  ;
  }

  @Override
  public void delete(Long id) {
  }

    
}
